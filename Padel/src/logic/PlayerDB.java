package logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class PlayerDB {
    private HashMap<String, Player> players;

    public PlayerDB () {
        players = new HashMap<>();
    }

    public void addPlayer(String name) {
        this.players.put(name, new Player(name));
        System.out.println("Added: " + name + " to the list!");
    }

    public void printPlayers() {
        for (String player : this.players.keySet()) {
            this.players.get(player).printPlayer();
            System.out.println("------------");
        }
    }

    public void addScore(String one, String two) {
        String[] gamePlayers = one.split(",");
        String[] gameResult = two.split("-");

        // Gameresults, win or equals
        if (Integer.valueOf(gameResult[0]) > Integer.valueOf(gameResult[1])) {
            players.get(gamePlayers[0]).addPoints(2);
            players.get(gamePlayers[1]).addPoints(2);
        } else if (Integer.valueOf(gameResult[0]) < Integer.valueOf(gameResult[1])){
            players.get(gamePlayers[2]).addPoints(2);
            players.get(gamePlayers[3]).addPoints(2);
        } else {
            for (int i = 0; i < 4; i++) {
                players.get(gamePlayers[i]).addPoints(1);
            }
        }
        for (int i = 0; i < gamePlayers.length; i++) {
            players.get(gamePlayers[i]).addGame();
        }
    }

    public void scoreList() {
        ArrayList<Player> highScore = new ArrayList<>();
        for (String name : players.keySet()) {
            highScore.add(players.get(name));
        }
        System.out.println("Printing the score:");
        highScore.sort(Comparator.comparing(o -> o.getPoints()));
        for (int i = 0; i < highScore.size(); i++) {
            highScore.get(i).printPlayer();
        }
        System.out.println("-----------");
    }

    public HashMap<String, Player> getPlayers() {
        return this.players;
    }

}
