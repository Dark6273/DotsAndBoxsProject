package com.project.example.dotsandboxsproject;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class Board {
    private static final Player[] players = new Player[2];
    private static int gameSize;
    private static Label board;
    private static Label turn;
    private static Rectangle turnBox;
    private static int countOfBox;
    public void board(Stage primaryStage) throws Exception {
        menu(primaryStage);
        primaryStage.show();
    }

    private static void gameBoard(Stage primaryStage) throws FileNotFoundException {
        /*
        call game scene and show on in the primary stage of the application

         */
        // background image
        Rectangle background = new Rectangle(0, 0, 500, 650);
        Image backgroundImage = new Image(new FileInputStream("src/main/resources/Images/backgroundGame.png"));
        background.setFill(new ImagePattern(backgroundImage));

        /*
        top box
        1- create a rectangle with the width and height of the game board
        2- set the fill of the rectangle to the image of the top box
        3- write the text "Dots and Boxes" in the rectangle
        4- write player board in the rectangle
        radius rectangle: (https://www.tutorialspoint.com/javafx/2dshapes_rounded_rectangle.htm)
         */

        Rectangle borderTop = new Rectangle(20, 20, 460, 130);
        borderTop.setFill(Color.TRANSPARENT);
        borderTop.setStroke(Paint.valueOf("#2c3e50"));
        borderTop.setStrokeWidth(3);
        borderTop.setArcHeight(30);
        borderTop.setArcWidth(30);

        Label Title = new Label("Dots and Boxes");
        Title.setStyle("-fx-font-size: 30px; -fx-text-fill: #2c3e50; -fx-font-family: 'Arial Black';");
        Title.setLayoutX(120);
        Title.setLayoutY(30);

        board = new Label(players[0].getName() + "  :  " + players[0].getScore() + "  =  " + players[1].getName() + " : " + players[1].getScore());
        board.setStyle("-fx-font-size: 20px; -fx-text-fill: #2c3e50; -fx-font-family: 'Arial Black';");
        board.setLayoutX(100);
        board.setLayoutY(90);
        board.setMaxWidth(300);

        Line[] menuLine = new Line[3];
        for (int i = 0; i < menuLine.length; i++) {
            menuLine[i] = new Line(440, (30 + (i * 12)), 470, (30 + (i * 12)));
            menuLine[i].setStroke(Paint.valueOf("#2c3e50"));
            menuLine[i].setStrokeWidth(3);
            menuLine[i].setCursor(javafx.scene.Cursor.HAND);
        }
        for (Line line : menuLine) {
            line.setOnMouseEntered(event -> {
                updateMenuLineEntered(menuLine);
            });
            line.setOnMouseClicked(event -> {
                try {
                    menu(primaryStage);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        Rectangle menuBox = new Rectangle(438, 28, 35, 30);
        menuBox.setFill(Color.TRANSPARENT);
        menuBox.setCursor(javafx.scene.Cursor.HAND);
        menuBox.setOnMouseEntered(event -> updateMenuLineEntered(menuLine));
        menuBox.setOnMouseExited(event -> updateMenuLineExited(menuLine));
        menuBox.setOnMouseClicked(event -> {
            try {
                menu(primaryStage);
                System.out.println("Exit Game and go to menu");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });



        /*
        bottom box
        1- create a rectangle with the width and height of the game board
        2- create Tiles and add them to the rectangle
        3- create Lines and add them to the rectangle
         */

        Rectangle borderBottom = new Rectangle(20, 160, 460, 460);
        borderBottom.setFill(Color.TRANSPARENT);
        borderBottom.setStroke(Paint.valueOf("#2c3e50"));
        borderBottom.setStrokeWidth(3);
        borderBottom.setArcHeight(30);
        borderBottom.setArcWidth(30);

        // create a box for view turn of player
        turnBox = new Rectangle(25, 165, 20, 20);
        turnBox.setFill(Paint.valueOf(players[0].getColor()));
        turnBox.setArcHeight(20);
        turnBox.setArcWidth(20);
        turnBox.setOnMouseEntered(event -> {
            try {
                show();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        turnBox.setOnMouseExited(event -> {
            try {
                hide();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });



        // create a label for helper view turn
        turn = new Label(players[0].getName() + "'s turn");
        turn.setStyle("-fx-font-size: 10px; -fx-text-fill: #fff; -fx-background-color: " + players[0].getColor() + ";-fx-font-family: 'Arial Black'; -fx-padding: 5px; -fx-background-radius: 10px;");
        turn.setLayoutX(50);
        turn.setLayoutY(165);
        turn.setOpacity(0); // hide the label


        Group root = new Group(background, borderTop, Title, board, borderBottom, turnBox, turn, menuBox, menuLine[0], menuLine[1], menuLine[2]);

        // Create tiles for the game board
        Rectangle[][] tiles = Tile.tile(gameSize);
        for (int i = 0; i < gameSize; i++)
            for (int j = 0; j < gameSize; j++)
                root.getChildren().add(tiles[i][j]);


        /*
        create lines for the game board
        create horizontal lines and add the Group root
        create vertical lines and add the Group root
        add with a for loop the lines to the Group root
         */
        Line[][] horizontal = Lines.horizontalLine(gameSize);
        for (int i = 0; i < gameSize; i++)
            for (int j = 0; j <= gameSize; j++)
                root.getChildren().add(horizontal[i][j]);


        Line[][] vertical = Lines.verticalLine(gameSize);
        for (int i = 0; i <= gameSize; i++)
            for (int j = 0; j < gameSize; j++)
                root.getChildren().add(vertical[i][j]);


        // create dots and add to the Group root
        Rectangle[][] dots = Tile.dots(gameSize);
        for (int i = 0; i <= gameSize; i++)
            for (int j = 0; j <= gameSize; j++)
                root.getChildren().add(dots[i][j]);


        checkBox.setLines(vertical, horizontal);


        Scene scene = new Scene(root,500, 650);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dots and Boxes " + players[0].getName() + " vs " + players[1].getName());
    }

    public static void menu(Stage primaryStage) throws FileNotFoundException {
        /*
        call menu scene and show on in the primary stage of the application
        */
        MenuBoard menuBoard = new MenuBoard();
        menuBoard.menu(primaryStage);
    }

    public static void alert(String message, String title, String header, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void checkUser(String user1, String user2, int size, Stage stage) throws FileNotFoundException {
        if(user1.equals("") || user2.equals(""))
            alert("Please enter your name", "Error", "Error", Alert.AlertType.ERROR);
        else if(user1.equals(user2))
            alert("Please enter different names", "Error", "Error", Alert.AlertType.ERROR);
        else
        {
            players[0] = new Player(user1, "#e74c3c");
            players[1] = new Player(user2, "#1abc9c");
            gameSize = size;
            countOfBox = gameSize * gameSize;
            Sound.soundStartGame();
            Game.setPlayers(players);
            System.out.println("Game Log: "  + user1 + " - " + user2 + "; size game: " + size);
            gameBoard(stage);
        }
    }

    public static void updateBoard() {
        if (players[0].getScore() > players[1].getScore()) {
            board.setText(players[0].getName() + "  :  " + players[0].getScore() + "  >  " + players[1].getName() + " : " + players[1].getScore());
            board.setStyle("-fx-font-size: 20px; -fx-text-fill: " + players[0].getColor() + "; -fx-font-family: 'Arial Black';");
        }
        else if (players[0].getScore() < players[1].getScore()) {
            board.setText(players[0].getName() + "  :  " + players[0].getScore() + "  <  " + players[1].getName() + " : " + players[1].getScore());
            board.setStyle("-fx-font-size: 20px; -fx-text-fill: " + players[1].getColor() + "; -fx-font-family: 'Arial Black';");
        }
        else {
            board.setText(players[0].getName() + "  :  " + players[0].getScore() + "  =  " + players[1].getName() + " : " + players[1].getScore());
            board.setStyle("-fx-font-size: 20px; -fx-text-fill: #2c3e50; -fx-font-family: 'Arial Black';");
        }
    }

    // turnBox helper label
    private static void show() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
        turn.setOpacity(80);
    }
    private static void hide() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
        turn.setOpacity(0);
    }

    // update turn box and helper label
    public static void updateTurn(Player currentPlayer) {
        turnBox.setFill(Paint.valueOf(currentPlayer.getColor()));
        turn.setText(currentPlayer.getName() + "'s turn");
        turn.setStyle("-fx-font-size: 10px; -fx-text-fill: #fff; -fx-background-color: " + currentPlayer.getColor() + ";-fx-font-family: 'Arial Black'; -fx-padding: 5px; -fx-background-radius: 10px;");
    }

    // update style of menu line
    private static void updateMenuLineEntered(Line[] lines){
        lines[0].setEndY(54);
        lines[2].setEndY(30);
        lines[1].setOpacity(0);
    }

    private static void  updateMenuLineExited(Line[] lines){
        lines[0].setStartY(30);
        lines[0].setEndY(30);
        lines[2].setStartY(54);
        lines[2].setEndY(54);
        lines[1].setOpacity(100);
    }

    public static void checkFinish()
    {
        countOfBox--;
        if (countOfBox == 0)
        {
            Player win = null;
            if (players[0].getScore() > players[1].getScore())
                win = players[0];
            else if (players[0].getScore() < players[1].getScore())
                win = players[1];
            assert win != null;
            Sound.soundWin();
            alert("","Win game","The " + win.getName() + " wins the game", Alert.AlertType.INFORMATION);
            board.setText("Winner of the game: " + win.getName());
            board.setStyle("-fx-font-size: 25px; -fx-text-fill: " + win.getColor() + "; -fx-font-family: 'Arial Black';");
            board.setLayoutX(60);
            board.setMaxWidth(380);
        }
    }
}
