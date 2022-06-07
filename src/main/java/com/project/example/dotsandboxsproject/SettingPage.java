package com.project.example.dotsandboxsproject;

import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.Optional;

public class SettingPage {
    private static Group group;
    public static void setting(Group root, Player[] players) throws IOException {
        group = root;

        Rectangle background = new Rectangle(0, 0, 500, 650);
        background.setOpacity(0.6);
        background.setFill(Color.BLACK);
        background.setOnMouseClicked(event -> { close(); });

        Rectangle settingBox = new Rectangle(3, 297, 494, 350);
        settingBox.setFill(Color.WHITE);
        settingBox.setId("settingBox");
        settingBox.setArcHeight(40);
        settingBox.setArcWidth(40);

        String[] playersName = Setting.getNamePlayers();
        String[] playersColor = Setting.getColorPlayers();

        Label settingTitle = new Label("Setting");
        settingTitle.setLayoutY(320);
        settingTitle.setPrefSize(500, 30);
        settingTitle.setAlignment(javafx.geometry.Pos.CENTER);
        settingTitle.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-font-family: 'Arial';");

        Rectangle player1Box = new Rectangle(30, 370, 440, 60);
        player1Box.setFill(Color.WHITE);
        player1Box.setStroke(Paint.valueOf(playersColor[0]));
        player1Box.setArcHeight(10);
        player1Box.setArcWidth(10);

        Label player1Title = new Label("Name: ");
        player1Title.setLayoutY(385);
        player1Title.setLayoutX(45);
        player1Title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-font-family: 'Arial'; -fx-text-fill: black;");

        TextField player1Name = new TextField(playersName[0]);
        player1Name.setLayoutY(380);
        player1Name.setLayoutX(120);
        player1Name.setPrefSize(270, 40);
        player1Name.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-font-family: 'Arial'; -fx-text-fill: " + playersColor[0] + "; -fx-border-color: white;");
        player1Name.setId("player1Name");

        ColorPicker player1Color = new ColorPicker(Color.valueOf(playersColor[0]));
        player1Color.setLayoutY(380);
        player1Color.setLayoutX(400);
        player1Color.setPrefSize(60, 40);
        player1Color.setStyle("-fx-border-color: white; -fx-background-color: white; -fx-cursor: hand;");
        player1Color.setId("player1Color");

        Label player1Label = new Label("Player 1");
        player1Label.setLayoutY(364);
        player1Label.setLayoutX(40);
        player1Label.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-font-family: 'Arial'; -fx-text-fill: black; -fx-background-color: white; -fx-padding: 0 5px;");

        Rectangle player2Box = new Rectangle(30, 450, 440, 60);
        player2Box.setFill(Color.WHITE);
        player2Box.setStroke(Color.valueOf(playersColor[1]));
        player2Box.setArcHeight(10);
        player2Box.setArcWidth(10);

        Label player2Title = new Label("Name: ");
        player2Title.setLayoutY(465);
        player2Title.setLayoutX(45);
        player2Title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-font-family: 'Arial'; -fx-text-fill: black;");

        TextField player2Name = new TextField(playersName[1]);
        player2Name.setLayoutY(460);
        player2Name.setLayoutX(120);
        player2Name.setPrefSize(270, 40);
        player2Name.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-font-family: 'Arial'; -fx-text-fill: " + playersColor[1] + "; -fx-border-color: white;");
        player2Name.setId("player2Name");

        ColorPicker player2Color = new ColorPicker(Color.valueOf(playersColor[1]));
        player2Color.setLayoutY(460);
        player2Color.setLayoutX(400);
        player2Color.setPrefSize(60, 40);
        player2Color.setStyle("-fx-border-color: white; -fx-background-color: white; -fx-cursor: hand;");
        player2Color.setId("player2Color");

        Label player2Label = new Label("Player 2");
        player2Label.setLayoutY(444);
        player2Label.setLayoutX(40);
        player2Label.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-font-family: 'Arial'; -fx-text-fill: black; -fx-background-color: white; -fx-padding: 0 5px;");

        CheckBox sound = new CheckBox("Sound");
        sound.setLayoutY(530);
        sound.setLayoutX(40);
        sound.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-font-family: 'Arial'; -fx-cursor: hand;");
        sound.setId("sound");
        sound.setSelected(Setting.getSound());
        
        CheckBox music = new CheckBox("Music");
        music.setLayoutY(530);
        music.setLayoutX(220);
        music.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-font-family: 'Arial'; -fx-cursor: hand;");
        music.setId("music");
        music.setSelected(Setting.getMusic());

        Button def = new Button("Default");
        def.setLayoutX(50);
        def.setLayoutY(580);
        def.setMinWidth(200);
        def.setStyle("-fx-font-size: 20px; -fx-background-color: #fff; -fx-text-fill: #c0392b; -fx-font-family: 'Arial Black'; -fx-border-color: #c0392b; -fx-border-width: 5px; -fx-border-radius: 10px;");
        def.setCursor(Cursor.HAND);
        def.setOnMouseEntered(event -> enteredButton(def, "#c0392b"));
        def.setOnMouseExited(event -> ExitButton(def, "#c0392b"));
        def.setOnMouseClicked(event -> {
            try {
                defaultSetting(players);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Button update = new Button("Update");
        update.setLayoutX(252);
        update.setLayoutY(580);
        update.setMinWidth(200);
        update.setStyle("-fx-font-size: 20px; -fx-background-color: #fff; -fx-text-fill: #27ae60; -fx-font-family: 'Arial Black'; -fx-border-color: #27ae60; -fx-border-width: 5px; -fx-border-radius: 10px;");
        update.setCursor(Cursor.HAND);
        update.setOnMouseEntered(event -> enteredButton(update, "#27ae60"));
        update.setOnMouseExited(event -> ExitButton(update, "#27ae60"));
        update.setOnMouseClicked(event -> {
            try {
                updateSetting(root, players);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        


        root.getChildren().addAll(background, settingBox, settingTitle, player1Box, player1Title, player1Name, player1Color, player1Label, player2Box, player2Title, player2Name, player2Color, player2Label, sound, music, def, update);
    }


    private static void close()
    {
        for (int i = 0; i < 17; i++)
        {
            group.getChildren().remove(group.getChildren().size() - 1);
        }
    }
    private static void defaultSetting(Player[] players) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Default Setting");
        alert.setHeaderText("Are you sure you want to reset the setting?");
        alert.setContentText("This will reset all the setting to default.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
            Setting.defaultSetting();

        String[] names = Setting.getNamePlayers();
        String[] colors = Setting.getColorPlayers();

        players[0].update(names[0], colors[0]);
        players[1].update(names[1], colors[1]);

        Board.updateBoard();
        close();
    }
    private static void updateSetting(Group root, Player[] players) throws IOException {
        TextField player1Name = (TextField) root.lookup("#player1Name");
        TextField player2Name = (TextField) root.lookup("#player2Name");
        ColorPicker player1Color = (ColorPicker) root.lookup("#player1Color");
        ColorPicker player2Color = (ColorPicker) root.lookup("#player2Color");
        CheckBox sound = (CheckBox) root.lookup("#sound");
        CheckBox music = (CheckBox) root.lookup("#music");

        if(player1Name.getText().equals("") || player2Name.getText().equals("") || player1Color.getValue().equals(player2Color.getValue()) || player1Name.getText().equals(player2Name.getText())){
            alert();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Update setting");
        alert.setHeaderText("Are you sure you want to update the setting?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() != ButtonType.OK)
            return;

        String[] names = {player1Name.getText(), player2Name.getText()};
        String[] colors = {toHexString(Color.valueOf(player1Color.getValue().toString())), toHexString(Color.valueOf(player2Color.getValue().toString()))};
        Setting.updatePlayer(names, colors);
        Setting.updateSound(sound.isSelected(), music.isSelected());
        System.out.println("Setting update");

        players[0].update(names[0], colors[0]);
        players[1].update(names[1], colors[1]);

        Board.updateBoard();

        close();
    }
    private static void enteredButton(Button button, String color)
    {
        button.setStyle("-fx-font-size: 20px; -fx-background-color: " + color + "; -fx-text-fill: white; -fx-font-family: 'Arial Black'; -fx-border-color: " + color + "; -fx-border-width: 5px; -fx-border-radius: 10px;");
    }

    private static void ExitButton(Button button, String color)
    {
        button.setStyle("-fx-font-size: 20px; -fx-background-color: #fff; -fx-text-fill: " + color + "; -fx-font-family: 'Arial Black'; -fx-border-color: " + color + "; -fx-border-width: 5px; -fx-border-radius: 10px;");
    }
    private static void alert()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Wrong Input");
        alert.setContentText("Please enter your name and choose different color");
        alert.showAndWait();
    }
    private static String format(double val) {
        String in = Integer.toHexString((int) Math.round(val * 255));
        return in.length() == 1 ? "0" + in : in;
    }

    public static String toHexString(Color value) {
        return "#" + (format(value.getRed()) + format(value.getGreen()) + format(value.getBlue()) + format(value.getOpacity()))
                .toUpperCase();
    }
}
