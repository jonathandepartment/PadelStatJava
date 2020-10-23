package logic;

public class Player {
    private String name;
    private int points, gamesPlayed;

    public Player() {
        this.name = "Sub";
        this.points = 0;
        this.gamesPlayed = 0;
    }

    public Player(String n) {
        this.name = n;
        this.points = 0;
        this.gamesPlayed = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void addGame() {
        this.gamesPlayed++;
    }

    public String toString() {
        return this.name + ": " + this.points + " poäng på " + this.gamesPlayed + " matcher";
    }
    public void printPlayer() {
        System.out.println(this.name + ": " + this.points + " points in " + this.gamesPlayed + " games.");
    }
    public String getName() {
        return this.name;
    }

    public int getGamesPlayed() {
        return this.gamesPlayed;
    }

    public int getPoints() {
        return this.points;
    }
}
