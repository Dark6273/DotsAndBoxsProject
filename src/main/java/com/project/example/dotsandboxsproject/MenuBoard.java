package com.project.example.dotsandboxsproject;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MenuBoard{

    public void menu(Stage primaryStage) throws FileNotFoundException {

        // open image and set it as background of the scene (help from https://stackoverflow.com/questions/43089878/how-to-set-background-image-in-javafx)
        Rectangle background = new Rectangle(0, 0, 500, 650);
        Image backgroundImage = new Image(new FileInputStream("src/main/resources/Images/menuBackground.png")); // image url: https://img.freepik.com/free-vector/abstract-geometric-boxes-background-dot-line-connection_41981-1432.jpg?w=740
        background.setFill(new ImagePattern(backgroundImage));


        /*
        Title and Player label and input box
        create a label for the title and set the font size and color
        css: https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html#:~:text=CSS%20styles%20are%20applied%20to,need%20CSS%20reapplied%20are%20visited.
        color: https://flatuicolors.com/palette/defo
        slider: https://docs.oracle.com/javafx/2/ui_controls/slider.htm
        player1 color: #e74c3c
        player2 color: #1abc9c
        */
        Label title = new Label("Dots and Boxes");
        title.setStyle("-fx-font-size: 40px; -fx-text-fill: #2c3e50; -fx-font-family: 'Arial Black';");
        title.setLayoutX(85);
        title.setLayoutY(70);

        Label player1 = new Label("Player 1");
        player1.setStyle("-fx-font-size: 20px; -fx-text-fill: #e74c3c; -fx-font-family: 'Arial Black'; -fx-background-color: #fff; -fx-border-color: #7f8c8d; -fx-border-width: 2px; -fx-border-radius: 10px; -fx-padding: 5px; -fx-opacity: 0.75;");
        player1.setLayoutX(65);
        player1.setLayoutY(180);

        Label player2 = new Label("Player 2");
        player2.setStyle("-fx-font-size: 20px; -fx-text-fill: #1abc9c; -fx-font-family: 'Arial Black'; -fx-background-color: #fff; -fx-border-color: #7f8c8d; -fx-border-width: 2px; -fx-border-radius: 10px; -fx-padding: 5px; -fx-opacity: 0.75;");
        player2.setLayoutX(65);
        player2.setLayoutY(300);

        TextField player1Input = new TextField("Player 1");
        player1Input.setStyle("-fx-font-size: 20px; -fx-text-fill: #e74c3c; -fx-font-family: 'Arial Black'; -fx-background-color: #fff; -fx-border-color: #34495e; -fx-border-width: 2px; -fx-border-radius: 10px; -fx-padding: 5px; -fx-opacity: 0.75;");
        player1Input.setLayoutX(160);
        player1Input.setLayoutY(240);
        player1Input.setId("player1");

        TextField player2Input = new TextField("Player 2");
        player2Input.setStyle("-fx-font-size: 20px; -fx-text-fill: #1abc9c; -fx-font-family: 'Arial Black'; -fx-background-color: #fff; -fx-border-color: #34495e; -fx-border-width: 2px; -fx-border-radius: 10px; -fx-padding: 5px; -fx-opacity: 0.75;");
        player2Input.setLayoutX(160);
        player2Input.setLayoutY(360);
        player2Input.setId("player2");


        Label gameSize = new Label("Game Size");
        gameSize.setStyle("-fx-font-size: 20px; -fx-text-fill: #2c3e50; -fx-font-family: 'Arial Black'; -fx-background-color: #fff; -fx-border-color: #7f8c8d; -fx-border-width: 2px; -fx-border-radius: 10px; -fx-padding: 5px; -fx-opacity: 0.75;");
        gameSize.setLayoutX(65);
        gameSize.setLayoutY(430);

        Slider gameSizeSlider = new Slider(1, 15, 8);
        gameSizeSlider.setStyle("-fx-font-size: 20px; -fx-text-fill: #2c3e50; -fx-font-family: 'Arial Black'; -fx-background-color: #fff; -fx-border-color: #7f8c8d; -fx-border-width: 2px; -fx-border-radius: 10px; -fx-padding: 5px; -fx-opacity: 0.75;");
        gameSizeSlider.setLayoutX(160);
        gameSizeSlider.setLayoutY(480);
        gameSizeSlider.setShowTickMarks(true);
        gameSizeSlider.setMajorTickUnit(1);
        gameSizeSlider.setMinorTickCount(0);
        gameSizeSlider.setBlockIncrement(1);
        gameSizeSlider.setSnapToTicks(true);
        gameSizeSlider.setMinWidth(260);

        Button startGame = new Button("Start");
        startGame.setStyle("-fx-font-size: 25px; -fx-text-fill: #16a085; -fx-font-family: 'Arial Black'; -fx-background-color: #fff; -fx-border-color: #16a085; -fx-border-width: 2px; -fx-border-radius: 10px; -fx-padding: 5px; -fx-opacity: 0.9;");
        startGame.setLayoutX(210);
        startGame.setLayoutY(550);
        startGame.setMinWidth(100);
        startGame.setCursor(javafx.scene.Cursor.HAND);
        startGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String player1 = player1Input.getText();
                String player2 = player2Input.getText();
                int size = (int) gameSizeSlider.getValue();

                try {
                    Board.checkUser(player1, player2, size, primaryStage);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Button programmer = new Button("PG :)");
        programmer.setStyle("-fx-font-size: 25px; -fx-text-fill: #92B4EC; -fx-font-family: 'Arial Black'; -fx-background-color: #fff; -fx-border-color: #92B4EC; -fx-border-width: 2px; -fx-border-radius: 10px; -fx-padding: 5px; -fx-opacity: 0.9;");
        programmer.setLayoutX(100);
        programmer.setLayoutY(550);
        programmer.setMinWidth(100);
        programmer.setCursor(javafx.scene.Cursor.HAND);
        programmer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    primaryStage.setScene(Programmer.author(primaryStage));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Button exit = new Button("Exit");
        exit.setStyle("-fx-font-size: 25px; -fx-text-fill: #E74C3C; -fx-font-family: 'Arial Black'; -fx-background-color: #fff; -fx-border-color: #E74C3C; -fx-border-width: 2px; -fx-border-radius: 10px; -fx-padding: 5px; -fx-opacity: 0.9;");
        exit.setLayoutX(315);
        exit.setLayoutY(550);
        exit.setMinWidth(100);
        exit.setCursor(javafx.scene.Cursor.HAND);
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Board.alert("Hoping to see you again\n\nGood Bye :)", "Exit game", "Exit Game", Alert.AlertType.INFORMATION);
                System.exit(0);
            }
        });


        Group menu = new Group(background, title, player1, player2, player1Input, player2Input, gameSize, gameSizeSlider, startGame, programmer, exit);
        primaryStage.setTitle("Dots and Boxes");
        primaryStage.setScene(new Scene(menu, 500, 650));
    }
}
