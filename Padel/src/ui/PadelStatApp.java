package ui;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.PlayerDB;

public class PadelStatApp extends Application {

    private PlayerDB players;
    @Override
    public void init() throws Exception {
        this.players = new PlayerDB();
    }
    @Override
    public void start(Stage window) {
        PlayerCreation playerCreate = new PlayerCreation(players);
        Statistics playerStats = new Statistics(players);
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

        layout.setStyle("-fx-background-color: WHITE;");
        // First view
        Label welcome = new Label("Välkommen till PadelStat!");
        layout.setCenter(welcome);

        // Scene
        Scene scene = new Scene(layout, 700,500);
        scene.getStylesheets().add("stylesheet.css");
        // Show
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(PadelStatApp.class);
    }
}
