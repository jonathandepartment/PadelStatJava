package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import logic.PlayerDB;

public class PlayerStat {

    private PlayerDB players;

    public PlayerStat(PlayerDB playDB) {
        this.players = playDB;
    }

    public Parent getView() {
        GridPane grid = new GridPane();
        Label windowLabel = new Label("Statistik för enskild spelare");
        Label playerLabel = new Label();
        TextField playersStat = new TextField();
        Button showPlayer = new Button("Sök spelare");

        showPlayer.setOnAction((event) -> {
            String player = playersStat.getText();

            if (players.getPlayers().containsKey(player)) {
                playerLabel.setText(players.getPlayers().get(player).toString());
            } else {
                playerLabel.setText("Kan inte hitta spelare");
            }
        });

        grid.add(windowLabel, 0,0);
        grid.add(playersStat,0,1);
        grid.add(showPlayer,0,3);
        grid.add(playerLabel,0,4);

        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10,10,10,10));

        return grid;
    }
}
