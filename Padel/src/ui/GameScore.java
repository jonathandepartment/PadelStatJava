package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import logic.PlayerDB;

public class GameScore {

    private PlayerDB players;

    public GameScore(PlayerDB playDb) {
        this.players = playDb;
    }

    public Parent getView() {
        GridPane layout = new GridPane();
        HBox menuOne = new HBox();

        //Components
        Label title = new Label("Lägg till resultat");
        Label confirmation = new Label();
        Button addResult = new Button("Lägg till");
        TextField inputField = new TextField("xx-xx");
        TextField playingPlayers = new TextField("spelare1,spelare2...");

        // TextField action
        inputField.setOnMouseClicked((event) -> {
            inputField.clear();
        });

        playingPlayers.setOnMouseClicked((event) -> {
            playingPlayers.clear();
        });

        // Button action
        addResult.setOnMouseClicked((event) -> {
            String score = inputField.getText();
            String participants = playingPlayers.getText();
            if (inputField.getText().isEmpty() || playingPlayers.getText().isEmpty()) {
                confirmation.setText("Felaktigt infört");
            } else {
                this.players.addScore(participants,score);
                confirmation.setText("Resultat infört!");
            }

            inputField.clear();
            playingPlayers.clear();
        });

        // Add components
        menuOne.getChildren().addAll(inputField, playingPlayers, addResult);
        menuOne.setSpacing(20);

        layout.add(title, 0,0);
        layout.add(menuOne,0,1);
        layout.add(confirmation,0,2);
        // Modify layout
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10,10,10,10));

        return layout;
    }
}
