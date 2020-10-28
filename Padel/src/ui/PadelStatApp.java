package ui;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.PlayerDB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PadelStatApp extends Application {

    private PlayerDB players;
    @Override
    public void init() throws Exception {
        this.players = new PlayerDB();
    }
    @Override
    public void start(Stage window) throws FileNotFoundException {
        PlayerCreation playerCreate = new PlayerCreation(players);
        Rankings playerStats = new Rankings(players);
        GameScore playerScore = new GameScore(players);
        PlayerStat onePlayer = new PlayerStat(players);

        // Main layout
        BorderPane layout = new BorderPane();

        // Main menu
        HBox menu = new HBox();
        menu.setPadding(new Insets(20,20,20,20));
        menu.setSpacing(10);

        // Main buttons
        Button addPlayer = new Button("Lägg till spelare");
        Button addScore = new Button("Lägg till resultat");
        Button viewPlayers = new Button("Rankings");
        Button viewPlayer = new Button("Visa spelare");
        ChoiceBox options = new ChoiceBox(FXCollections.observableArrayList(
                "Open file", "Save"
        ));

        menu.getChildren().addAll(addPlayer,addScore,viewPlayer,viewPlayers, options);
        layout.setTop(menu);

        // Button logic
        addPlayer.setOnAction((event) -> layout.setCenter(playerCreate.getView()));
        addScore.setOnAction((event) -> layout.setCenter(playerScore.getView()));
        viewPlayers.setOnAction((event) -> layout.setCenter(playerStats.getView()));
        viewPlayer.setOnAction((event) -> layout.setCenter(onePlayer.getView()));

        // Styles
        addPlayer.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        addScore.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        viewPlayers.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        viewPlayer.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        // Image
        /*
        Image logo = new Image(new FileInputStream("/home/jonathan/Documents/logoPadel.png"));
        ImageView imageView = new ImageView(logo);
        imageView.setX(350);
        imageView.setY(250);*/

        layout.setStyle("-fx-background-color: WHITE;");
        // First view
        Label welcome = new Label("Välkommen till PadelStat!");
        //layout.setTop(imageView);
        layout.setCenter(welcome);

        // Scene
        Scene scene = new Scene(layout, 700,500);
        scene.getStylesheets().add("stylesheet.css");

        // Show
        window.setScene(scene);
        window.setTitle("PadelStats");
        window.show();

    }

    public static void main(String[] args) {
        launch(PadelStatApp.class);
    }
}
