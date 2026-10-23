
import java.util.*;
import java.util.regex.*;

abstract class Question {
    abstract double grade(String correct, String answer,
                          double points);
}

class MCQ extends Question {
    @Override
    double grade(String correct, String answer, double points) {
        return correct.equals(answer) ? points : 0;
    }
}

class TrueFalse extends Question {
    @Override 
    double grade(String correct, String answer, double points) {
        return correct.equals(answer) ? points : 0;
    }
}

class Essay extends Question {
    @Override 
    double grade(String correct, String answer, double points) {
        String[] keywords = correct.split(",");
        int count = 0;

        for (String keyword : keywords) {
            if (answer.toLowerCase().contains(
                    keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) return points * 0.75;
        if (count == 1) return points * 0.50;
        return 0;
    }
}

public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());
            double total = 0;
            
            Pattern pattern = Pattern.compile(
                    "^(MCQ|TF|ESSAY)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)\\s*$"
            );
            
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                Matcher m = pattern.matcher(line);
                
                if (!m.matches()) {
                    throw new IllegalArgumentException(
                            "Invalid question input: " + line);
                }
                
                String type = m.group(1);
                String correct = m.group(3);
                String answer = m.group(4);
                double points = Double.parseDouble(m.group(5));
                
                Question q;
                q = switch (type) {
                    case "MCQ" -> new MCQ();
                    case "TF" -> new TrueFalse();
                    default -> new Essay();
                };
                
                double score = q.grade(correct, answer, points);
                System.out.printf("%s: %.2f%n", type, score);
                total += score;
            }
            
            System.out.printf("Total Score: %.2f%n", total);
        }
    }
}
