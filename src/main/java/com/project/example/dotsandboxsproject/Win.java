package com.project.example.dotsandboxsproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Win {
    public static void win(Group root, Stage stage, Player win) throws FileNotFoundException {
        /*
        1. Create a new Rectangle for background of the window
        2- Create a new Rectangle for the winner box
        3- Create two Buttons 1- Play Again 2- Exit
         */
        Rectangle background = new Rectangle(0, 0, 500, 650);
        background.setOpacity(0.6);
        background.setFill(Color.BLACK);
        background.setId("backgroundMenu");

        Rectangle winnerBox = new Rectangle(3, 297, 494, 350);
        winnerBox.setFill(Color.WHITE);
        winnerBox.setId("winnerBox");
        winnerBox.setArcHeight(40);
        winnerBox.setArcWidth(40);


        Label winner;
        if (win != null) {
            winner = new Label("Winner is: " + win.getName());
            winner.setStyle("-fx-font-size: 25px; -fx-text-fill: " + win.getColor() + "; -fx-font-family: 'Arial Black'; -fx-text-alignment: center;");
        }
        else {
            winner = new Label("Draw");
            winner.setStyle("-fx-font-size: 25px; -fx-text-fill: #000; -fx-font-family: 'Arial Black'; -fx-text-alignment: center;");
        }
        winner.setPrefSize(450, 50);
        winner.setMaxWidth(450);
        winner.setLayoutX(25);
        winner.setLayoutY(320);
        winner.setAlignment(javafx.geometry.Pos.CENTER);

        Image winnerGif;
        Rectangle winnerGifBox;
        if (win != null) {
            winnerGif = new Image(new FileInputStream("src/main/resources/Gif/winner.gif"));
            winnerGifBox = new Rectangle(50, 320, 400, 300);
            winnerGifBox.setFill(new ImagePattern(winnerGif));
        }
        else{
            winnerGif = new Image(new FileInputStream("src/main/resources/Gif/draw.gif"));
            winnerGifBox = new Rectangle(50, 310, 400, 300);
            winnerGifBox.setFill(new ImagePattern(winnerGif));
        }

        Button exit = new Button("Exit");
        exit.setLayoutX(252);
        exit.setLayoutY(580);
        exit.setMinWidth(150);
        exit.setStyle("-fx-font-size: 20px; -fx-background-color: #fff; -fx-text-fill: #c0392b; -fx-font-family: 'Arial Black'; -fx-border-color: #c0392b; -fx-border-width: 5px; -fx-border-radius: 10px;");
        exit.setCursor(Cursor.HAND);
        exit.setOnMouseEntered(event -> enteredButton(exit, "#c0392b"));
        exit.setOnMouseExited(event -> exitButton(exit, "#c0392b"));
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Board.alert("Hoping to see you again\n\nGood Bye :)", "Exit game", "Exit Game", Alert.AlertType.INFORMATION);
                System.exit(0);
            }
        });

        Button menu = new Button("Menu");
        menu.setLayoutX(100);
        menu.setLayoutY(580);
        menu.setMinWidth(148);
        menu.setStyle("-fx-font-size: 20px; -fx-background-color: #fff; -fx-text-fill: #27ae60; -fx-font-family: 'Arial Black'; -fx-border-color: #27ae60; -fx-border-width: 5px; -fx-border-radius: 10px;");
        menu.setCursor(Cursor.HAND);
        menu.setOnMouseEntered(event -> enteredButton(menu, "#27ae60"));
        menu.setOnMouseExited(event -> exitButton(menu, "#27ae60"));
        menu.setOnMouseClicked(event -> {
            try {
                Board.menu(stage);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        root.getChildren().addAll(background, winnerBox, winnerGifBox, winner, exit, menu);
    }

    private static void enteredButton(Button button, String color)
    {
        button.setStyle("-fx-font-size: 20px; -fx-background-color: " + color + "; -fx-text-fill: white; -fx-font-family: 'Arial Black'; -fx-border-color: " + color + "; -fx-border-width: 5px; -fx-border-radius: 10px;");
    }

    private static void exitButton(Button button, String color)
    {
        button.setStyle("-fx-font-size: 20px; -fx-background-color: #fff; -fx-text-fill: " + color + "; -fx-font-family: 'Arial Black'; -fx-border-color: " + color + "; -fx-border-width: 5px; -fx-border-radius: 10px;");
    }
}
