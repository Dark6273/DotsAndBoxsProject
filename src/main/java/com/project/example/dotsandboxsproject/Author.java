package com.project.example.dotsandboxsproject;

import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Author {
    public static Scene author(Stage primaryStage) throws FileNotFoundException {
        /*
        create author scene
        with background image
        with author name
        fill background image (help from https://stackoverflow.com/questions/43089878/how-to-set-background-image-in-javafx)
         */
        Rectangle background = new Rectangle(0,0,500,650);
        Image backgroundImage = new Image(new FileInputStream("src/main/resources/Images/backgroundAuthor.png"));
        background.setFill(new ImagePattern(backgroundImage));

        // create author name
        Label authorName = new Label("Programmer: \nMahdi Khosravi");
        authorName.setStyle("-fx-font-size: 28px; -fx-text-fill: #7f8c8d; -fx-font-family: 'Arial';");
        authorName.setLayoutX(20);
        authorName.setLayoutY(120);

        Label university = new Label("University: \nShahrood University");
        university.setStyle("-fx-font-size: 28px; -fx-text-fill: #7f8c8d; -fx-font-family: 'Arial';");
        university.setLayoutX(20);
        university.setLayoutY(300);

        Button menu = new Button("Menu");
        menu.setStyle("-fx-font-size: 25px; -fx-text-fill: #7f8c8d; -fx-font-family: 'Arial Black'; -fx-background-color: unset; -fx-border-color: #7f8c8d; -fx-border-width: 2px; -fx-border-radius: 10px; -fx-padding: 5px; -fx-opacity: 0.9;");
        menu.setLayoutX(20);
        menu.setLayoutY(400);
        menu.setMinWidth(200);
        menu.setCursor(Cursor.HAND);
        menu.setOnMouseClicked(event -> {
            try {
                Board.menu(primaryStage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Group root = new Group(background, authorName, university, menu);
        return new Scene(root, 500, 650);
    }
}
