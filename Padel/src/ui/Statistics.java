package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import logic.PlayerDB;

public class Statistics {
    private LineChart<Number, Number> lineChart;
    private PlayerDB players;

    public Statistics(PlayerDB playerDB) {
        this.players = playerDB;
        this.lineChart = createEmptyChart();
    }

    public Parent getView() {
        GridPane layout = new GridPane();
        Button showStats = new Button("Uppdatera");

        // Button action
        showStats.setOnMouseClicked((event) -> {
            lineChart.getData().clear();
            setChart(createChart());
        });
        // Layout
        layout.add(lineChart,0,0);
        layout.add(showStats,0,1);

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10,10,10,10));

        return layout;
    }

    public LineChart<Number,Number> createChart() {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Antal matcher");
        yAxis.setLabel("Poäng");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis,yAxis);
        lineChart.setTitle("Spelarstatistik Padel");

        for (String name : this.players.getPlayers().keySet()) {
            XYChart.Series data = new XYChart.Series();
            data.getData().add(new XYChart.Data(this.players.getPlayers().get(name).getGamesPlayed(),
                    this.players.getPlayers().get(name).getPoints()));
            data.setName(name);
            lineChart.getData().add(data);
        }
        return lineChart;
    }

    public LineChart<Number, Number> createEmptyChart() {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Antal matcher");
        yAxis.setLabel("Poäng");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis,yAxis);
        lineChart.setTitle("Spelarstatistik Padel");

        return lineChart;
    }

    public void setChart(LineChart chart) {
        this.lineChart = chart;
    }
}
