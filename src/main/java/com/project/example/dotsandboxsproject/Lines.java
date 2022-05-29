package com.project.example.dotsandboxsproject;

import javafx.scene.control.Alert;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

/*
 * This class is used to create a line between two points.
 * check the line is horizontal or vertical.
 * check used line and change color.
 * when hover mouse over the line change color to player color.
 * and when mouse is out change color to default color.
 * and click on the line change color to "#7f8c8d".
 *
 * check win box
 * default color is "#7f8c8d"
 * used color is "#34495e"
 */

public class Lines{
    private static Player currentPlayer = Game.currentPlayer(false);
    public static Line[][] horizontalLine(int size)
    {
        Line[][] lines = new Line[size][size + 1];
        int width = 460 / (size + 2);
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size + 1; j++)
            {
                lines[i][j] = new Line((i + 1) * width + 20, (j + 1) * width + 160, (i + 2) * width + 20, (j + 1) * width + 160);
                lines[i][j].setStroke(Paint.valueOf("#7f8c8d"));
                lines[i][j].setStrokeWidth(5);
                lines[i][j].setCursor(javafx.scene.Cursor.HAND);
                int finalI = i;
                int finalJ = j;
                lines[i][j].setOnMouseEntered(mouseEvent -> mouseHover(lines[finalI][finalJ]));
                lines[i][j].setOnMouseExited(mouseEvent -> mouseExit(lines[finalI][finalJ]));
                lines[i][j].setOnMouseClicked(mouseEvent -> mouseClick(lines[finalI][finalJ], size));
                lines[i][j].setId(i + "," + j + ",horizontal");
            }
        }
        return lines;
    }

    public static Line[][] verticalLine(int size)
    {
        Line[][] lines = new Line[size + 1][size];
        int width = 460 / (size + 2);
        for(int i = 0; i < (size + 1); i++)
        {
            for(int j = 0; j < size; j++)
            {
                lines[i][j] = new Line((i + 1) * width + 20, (j + 1) * width + 160, (i + 1) * width + 20, (j + 2) * width + 160);
                lines[i][j].setStroke(Paint.valueOf("#7f8c8d"));
                lines[i][j].setStrokeWidth(5);
                lines[i][j].setCursor(javafx.scene.Cursor.HAND);
                int finalI = i;
                int finalJ = j;
                lines[i][j].setOnMouseEntered(mouseEvent -> mouseHover(lines[finalI][finalJ]));
                lines[i][j].setOnMouseExited(mouseEvent -> mouseExit(lines[finalI][finalJ]));
                lines[i][j].setOnMouseClicked(mouseEvent -> mouseClick(lines[finalI][finalJ], size));
                lines[i][j].setId(i + "," + j + ",vertical");
            }
        }
        return lines;
    }

    public static void mouseHover(Line line)
    {
        Player currentPlayer = Game.currentPlayer(false);
        if (line.getStroke().equals(Paint.valueOf("#7f8c8d")))
            line.setStroke(Paint.valueOf(currentPlayer.getColor()));
    }

    public static void mouseExit(Line line)
    {
        if (line.getStroke().equals(Paint.valueOf(Game.currentPlayer(false).getColor())))
            line.setStroke(Paint.valueOf("#7f8c8d"));
    }

    public static void mouseClick(Line line, int size)
    {
        if (!line.getStroke().equals(Paint.valueOf("#34495e"))) {
            line.setStroke(Paint.valueOf("#34495e"));
            line.setCursor(javafx.scene.Cursor.DEFAULT);
            line.setStrokeWidth(6);
            System.out.println(currentPlayer.getName() + " move " + line.getId());
            boolean changePlayer = checkBox.checkWin(line.getId(), size, currentPlayer);

            if (!changePlayer) {
                currentPlayer = Game.currentPlayer(true);
            } else {
                currentPlayer = Game.currentPlayer(false);
                Board.checkFinish();
            }

            Board.updateTurn(currentPlayer);
        }
        else
            alert("You can't put here!", "Error: Used Line select!!!", "You can't put here!\nPlease choose another place.");
    }

    public static void alert(String title, String header, String content)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
