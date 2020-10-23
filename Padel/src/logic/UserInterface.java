package logic;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private PlayerDB players;

    public void start() {
        players = new PlayerDB();
        startMenu();
    }

    public void setUpGame() {

    }

    public void startMenu() {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome PadelStats!");
            System.out.println("1 - Add Player");
            System.out.println("2 - Add Score");
            System.out.println("3 - Print total scores");
            System.out.println("4 - Get player stats");
            System.out.println("5 - Exit the program");

            String input = scanner.nextLine();
            if (input.equals("5")) {
                System.out.println("Exiting, thank you for using PadelStat!");
                break;
            }

            if (input.equals("1")) {
                addPlayer();
            }

            if (input.equals("2")) {
                addScore();
            }

            if (input.equals("3")) {
                printScores();
            }

            if (input.equals("4")) {
                getPlayer();
            }
        }
    }
    public void addPlayer() {
        scanner = new Scanner(System.in);
        System.out.println("What is the players name?");
        String name = scanner.nextLine();
        players.addPlayer(name);
    }

    public void addScore(){
        scanner = new Scanner(System.in);
        System.out.println("Who played? (player1,player2,player3,player4");
        String inputOne = scanner.nextLine();
        System.out.println("What was the score? (xx-xx)");
        String inputTwo = scanner.nextLine();
        players.addScore(inputOne, inputTwo);
    }

    public void printScores() {
        players.scoreList();
    }

    public void getPlayer() {
        scanner = new Scanner(System.in);
        System.out.println("Enter player name:");
        String input = scanner.nextLine();

    }
}
