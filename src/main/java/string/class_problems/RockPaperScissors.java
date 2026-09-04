package string.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static String getComputerMove() {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        return moves[random.nextInt(moves.length)];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rounds = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Rock-Paper-Scissors Game");
        System.out.println("------------------------");

        for (int round = 1; round <= rounds; round++) {

            System.out.print("Round " + round + " - Enter Rock, Paper, or Scissors: ");
            String playerMove = scanner.nextLine();

            playerMove = formatMove(playerMove);

            String computerMove = getComputerMove();
            String result = playRound(playerMove, computerMove);

            System.out.println("Player: " + playerMove);
            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);
            System.out.println();

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("Final Summary");
        System.out.println("-------------");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

        scanner.close();
    }

    public static String formatMove(String move) {
        move = move.trim();

        if (move.equalsIgnoreCase("rock")) {
            return "Rock";
        } else if (move.equalsIgnoreCase("paper")) {
            return "Paper";
        } else if (move.equalsIgnoreCase("scissors")) {
            return "Scissors";
        }

        return "Rock";
    }
}