package com.project.example.dotsandboxsproject;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

public class checkBox {
    /*
    check complete box with line
    used stack overflow this way check wi
     */
    private static Line[][] verticalLines;
    private static Line[][] horizontalLines;
    
    public static boolean checkWin(String id, int size, Player currentPlayer)
    {
        String[] data = id.split(",");
        int x = Integer.parseInt(data[0]);
        int y = Integer.parseInt(data[1]);
        boolean win = false;

        if (data[2].equals("vertical"))
        {
            if (x == 0 ) {
                if (checkRight(x, y, currentPlayer)) win = true;
            } else if (x == size) {
                if (checkLeft(x, y, currentPlayer)) win = true;
            } else {
                if (checkLeft(x, y, currentPlayer)) win = true;
                if (checkRight(x, y, currentPlayer)) win = true;
            }
        }
        else
        {
            if (y == 0) {
                if (checkDown(x, y, currentPlayer)) win = true;
            } else if (y == size) {
                if (checkUp(x, y, currentPlayer)) win = true;
            }
            else {
                if (checkUp(x, y, currentPlayer)) win = true;
                if (checkDown(x, y, currentPlayer)) win = true;
            }
        }
        Board.updateBoard();
        return win;
    }

    private static boolean checkUp(int x, int y, Player currentPlayer)
    {
        if (checkLine(x, (y-1), verticalLines) && checkLine(x, (y-1), horizontalLines) && checkLine((x+1), (y-1), verticalLines))
        {
            currentPlayer.addScore();
            System.out.println(currentPlayer.getName() + ": " + currentPlayer.getScore());
            Tile.changeColor(x, (y - 1), currentPlayer.getColor());
            return true;
        }
        else
            return false;
    }

    private static boolean checkDown(int x, int y, Player currentPlayer)
    {
        if (checkLine(x, (y+1), horizontalLines) && checkLine(x, y, verticalLines) && checkLine((x+1), y, verticalLines)) {
            currentPlayer.addScore();
            System.out.println(currentPlayer.getName() + ": "+ currentPlayer.getScore());
            Tile.changeColor(x, y, currentPlayer.getColor());
            return true;
        }
        return false;
    }

    private static boolean checkRight(int x, int y, Player currentPlayer)
    {
        if (checkLine((x+1), y, verticalLines) && checkLine(x, y, horizontalLines) && checkLine(x, (y+1), horizontalLines))
        {
            currentPlayer.addScore();
            System.out.println(currentPlayer.getName() + ": " + currentPlayer.getScore());
            Tile.changeColor(x, y, currentPlayer.getColor());
            return true;
        }
        return false;
    }

    private static boolean checkLeft(int x, int y, Player currentPlayer)
    {
        if (checkLine((x-1), y, verticalLines) && checkLine((x-1), y, horizontalLines) && checkLine((x-1), (y+1), horizontalLines))
        {
            currentPlayer.addScore();
            System.out.println(currentPlayer.getName() + ": " + currentPlayer.getScore());
            Tile.changeColor((x - 1), y, currentPlayer.getColor());
            return true;
        }
        return false;
    }

    private static boolean checkLine(int x, int y, Line[][] line){
        return  (line[x][y].getStroke().equals(Paint.valueOf("#34495e")));
    }

    public static void setLines(Line[][] vertical, Line[][] horizontal) {
        verticalLines = vertical;
        horizontalLines = horizontal;
    }
}
