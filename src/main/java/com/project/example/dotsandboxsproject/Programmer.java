package com.project.example.dotsandboxsproject;

import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Programmer {
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
        authorName.setLayoutY(90);

        Label email = new Label("Email:");
        email.setStyle("-fx-font-size: 28px; -fx-text-fill: #7f8c8d; -fx-font-family: 'Arial';");
        email.setLayoutX(20);
        email.setLayoutY(170);

        Hyperlink emailAddress = new Hyperlink("Mahdi.khosravi6273@gmail.com");
        emailAddress.setStyle("-fx-font-size: 20px; -fx-text-fill: #7f8c8d; -fx-font-family: 'Arial';");
        emailAddress.setLayoutX(20);
        emailAddress.setLayoutY(200);
        emailAddress.setCursor(Cursor.HAND);
        emailAddress.setOnMouseClicked(e -> {
            try {
                Desktop.getDesktop().mail(java.net.URI.create("mailto:mahdi.khosravi6273@gmail.com"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Label github = new Label("Github:");
        github.setStyle("-fx-font-size: 28px; -fx-text-fill: #7f8c8d; -fx-font-family: 'Arial';");
        github.setLayoutX(20);
        github.setLayoutY(240);

        Hyperlink githubAddress = new Hyperlink("https://github.com/Dark6273");
        githubAddress.setStyle("-fx-font-size: 20px; -fx-text-fill: #7f8c8d; -fx-font-family: 'Arial';");
        githubAddress.setLayoutX(20);
        githubAddress.setLayoutY(270);
        githubAddress.setCursor(Cursor.HAND);
        githubAddress.setOnMouseClicked(e -> {
            try {
                Desktop.getDesktop().browse(java.net.URI.create("https://github.com/dark6273"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Label university = new Label("University: \nShahrood University");
        university.setStyle("-fx-font-size: 28px; -fx-text-fill: #7f8c8d; -fx-font-family: 'Arial';");
        university.setLayoutX(20);
        university.setLayoutY(330);

        Button menu = new Button("Menu");
        menu.setStyle("-fx-font-size: 25px; -fx-text-fill: #7f8c8d; -fx-font-family: 'Arial Black'; -fx-background-color: unset; -fx-border-color: #7f8c8d; -fx-border-width: 2px; -fx-border-radius: 10px; -fx-padding: 5px; -fx-opacity: 0.9;");
        menu.setLayoutX(20);
        menu.setLayoutY(430);
        menu.setMinWidth(200);
        menu.setCursor(Cursor.HAND);
        menu.setOnMouseClicked(event -> {
            try {
                Board.menu(primaryStage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Group root = new Group(background, authorName, university, menu, email, emailAddress, github, githubAddress);
        return new Scene(root, 500, 650);
    }
}
