package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import logic.PlayerDB;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class PlayerCreation {
    private PlayerDB players;

    public PlayerCreation(PlayerDB playersDB) {
        this.players = playersDB;
    }
    public Parent getView() {
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10,10,10,10));

        TextField inputName = new TextField("Skriv in spelarnamn");
        Button addPlayer = new Button("Lägg till");
        Label resultText = new Label("");

        inputName.setOnMouseClicked((event) -> {
            inputName.clear();
        });
        //Button logic
        addPlayer.setOnMouseClicked((event) -> {
            String input = inputName.getText();

            if (this.players.getPlayers().containsKey(input)) {
                resultText.setText("Spelaren finns redan, försök igen");
                inputName.clear();
            } else {
                players.addPlayer(input);
                resultText.setText("Lagt till " + input + " i databasen!");
                inputName.clear();
            }
        });

        layout.add(inputName,0,1);
        layout.add(addPlayer,0,2);
        layout.add(resultText,0,3);
        return layout;
    }
}
