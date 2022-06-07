package com.project.example.dotsandboxsproject;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public class MenuGame{
    public static void menu(Group root, Line[] menuLine, Stage stage, Player[] players) {
        /*
        crete a rectangle and set opacity 60 percent
        in center add another rectangle and add tree button 1-exit game, 2-resume, 3-menu
         */
        Rectangle background = new Rectangle(0, 0, 500, 650);
        background.setOpacity(0.6);
        background.setFill(Color.BLACK);
        background.setId("backgroundMenu");
        background.setOnMouseClicked(event -> resumeGame(root, menuLine));

        Rectangle menuBox = new Rectangle(3, 398, 494, 250);
        menuBox.setFill(Paint.valueOf("#ecf0f1"));
        menuBox.setArcHeight(40);
        menuBox.setArcWidth(40);
        menuBox.setId("menuBox");

        Button resume = new Button("Resume");
        resume.setLayoutX(57);
        resume.setLayoutY(440);
        resume.setMinWidth(380);
        resume.setStyle("-fx-font-size: 20px; -fx-background-color: #ecf0f1; -fx-text-fill: #16a085; -fx-font-family: 'Arial Black'; -fx-border-color: #16a085; -fx-border-width: 5px; -fx-border-radius: 10px;");
        resume.setCursor(Cursor.HAND);
        resume.setOnMouseEntered(event -> enteredButton(resume, "#16a085"));
        resume.setOnMouseExited(event -> exitButton(resume, "#16a085"));
        resume.setOnMouseClicked(event -> resumeGame(root, menuLine));


        Button setting = new Button("Setting");
        setting.setLayoutX(57);
        setting.setLayoutY(500);
        setting.setMinWidth(380);
        setting.setStyle("-fx-font-size: 20px; -fx-background-color: #ecf0f1; -fx-text-fill: #27ae60; -fx-font-family: 'Arial Black'; -fx-border-color: #27ae60; -fx-border-width: 5px; -fx-border-radius: 10px;");
        setting.setCursor(Cursor.HAND);
        setting.setOnMouseEntered(event -> enteredButton(setting, "#27ae60"));
        setting.setOnMouseExited(event -> exitButton(setting, "#27ae60"));
        setting.setOnMouseClicked(event -> {
            try {
                SettingPage.setting(root, players);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


        Button menu = new Button("Menu");
        menu.setLayoutX(57);
        menu.setLayoutY(560);
        menu.setMinWidth(380);
        menu.setStyle("-fx-font-size: 20px; -fx-background-color: #ecf0f1; -fx-text-fill: #c0392b; -fx-font-family: 'Arial Black'; -fx-border-color: #c0392b; -fx-border-width: 5px; -fx-border-radius: 10px;");
        menu.setCursor(Cursor.HAND);
        menu.setOnMouseEntered(event -> enteredButton(menu, "#c0392b"));
        menu.setOnMouseExited(event -> exitButton(menu, "#c0392b"));
        menu.setOnMouseClicked(event -> {
            try {
                Board.menu(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        root.getChildren().addAll(background, menuBox, resume, menu, setting);
    }

    private static void resumeGame(Group root, Line[] menuLine) {
        root.getChildren().remove(root.getChildren().size() - 1);
        root.getChildren().remove(root.getChildren().size() - 1);
        root.getChildren().remove(root.getChildren().size() - 1);
        root.getChildren().remove(root.getChildren().size() - 1);
        root.getChildren().remove(root.getChildren().size() - 1);
        Board.updateMenuLineExited(menuLine);
    }

    private static void enteredButton(Button button, String color)
    {
        button.setStyle("-fx-font-size: 20px; -fx-background-color: " + color + "; -fx-text-fill: white; -fx-font-family: 'Arial Black'; -fx-border-color: " + color + "; -fx-border-width: 5px; -fx-border-radius: 10px;");
    }

    private static void exitButton(Button button, String color)
    {
        button.setStyle("-fx-font-size: 20px; -fx-background-color: #ecf0f1; -fx-text-fill: " + color + "; -fx-font-family: 'Arial Black'; -fx-border-color: " + color + "; -fx-border-width: 5px; -fx-border-radius: 10px;");
    }
}
