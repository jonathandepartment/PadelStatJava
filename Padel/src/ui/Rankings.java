package ui;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import logic.PlayerDB;

public class Rankings {
    private PlayerDB players;

    public Rankings(PlayerDB players) {
        this.players = players;
    }

    public Parent getView() {
        BorderPane layout = new BorderPane();
        VBox rankings = new VBox();

        Label infoLabel = new Label("");
        Button updateButton = new Button("Uppdatera listan");

        updateButton.setOnMouseClicked((event) -> {
            rankings.getChildren().clear();
            updateList(rankings);
            infoLabel.setText("Listan uppdaterad");
        });
        layout.setRight(updateButton);
        layout.setCenter(rankings);
        layout.setBottom(infoLabel);

        rankings.setAlignment(Pos.CENTER);

        return layout;
    }

    public void updateList(VBox rankings) {

        for (String name : this.players.getPlayers().keySet()) {
            Label player = new Label(this.players.getPlayers().get(name).toString());
            player.setFont(new Font("Arial", 24));

            rankings.getChildren().add(player);
        }

    }
}
