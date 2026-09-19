import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsGame {

    
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if (
            (playerMove.equalsIgnoreCase("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equals("Paper"))
        ) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        int wins = 0;
        int losses = 0;
        int draw = 0;

        String[] moves = {"Rock", "Paper", "Scissors"};
        int totalRounds = 3;

        String[] playerMoveHistory = new String[totalRounds];
        String[] computerMoveHistory = new String[totalRounds];
        String[] resultHistory = new String[totalRounds];

        System.out.println("=== Rock Paper Scissors Game ===");

        for (int i = 0; i < totalRounds; i++) {
            System.out.println("\n--- Round " + (i + 1) + " ---");
            System.out.print("Enter your input ('Rock', 'Paper', 'Scissors'): ");
            String playerMove = scan.nextLine();

            
            String computerMove = moves[random.nextInt(3)];

            
            playerMoveHistory[i] = playerMove;
            computerMoveHistory[i] = computerMove;

            
            String result = playRound(playerMove, computerMove);
            resultHistory[i] = result;

            
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draw++;
            }

            System.out.println("Computer chose: " + computerMove);
            System.out.println("Result: " + result);
        }

        System.out.println("\n==============================================");
        System.out.println("Final Summary (after " + totalRounds + " rounds)");
        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < totalRounds; i++) {
            System.out.println((i + 1) + "     | " + playerMoveHistory[i] + "       | " + computerMoveHistory[i] + "     | " + resultHistory[i]);
        }

        double winPercentage = (wins * 100.0) / totalRounds;
        System.out.println("----------------------------------------------");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draw + " | Win % = " + winPercentage + "%");
        System.out.println("==============================================");

        scan.close();
    }
}