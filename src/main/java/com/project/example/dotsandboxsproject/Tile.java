package com.project.example.dotsandboxsproject;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Tile {
    private static Rectangle[][] tiles;

    public static Rectangle[][] tile(int size)
    {
        Rectangle[][] tile = new Rectangle[size][size];
        int i = 0, j = 0, width = 460 / (size + 2);
        for (i = 0; i < size; i++)
            for (j = 0; j < size; j++)
            {
                tile[i][j] = new Rectangle(((i + 1) * width + 20), ((j + 1) * width + 160), width, width);
                tile[i][j].setFill(Color.TRANSPARENT);
                tile[i][j].setStroke(Color.WHITE);
            }
        tiles = tile;
        return tile;
    }

    public static Rectangle[][] dots(int size)
    {
        Rectangle[][] dots = new Rectangle[size + 1][size + 1];
        int i = 0, j = 0, width = 460 / (size + 2);
        for (i = 0; i <= size; i++)
            for (j = 0; j <= size; j++)
            {
                dots[i][j] = new Rectangle(((i + 1) * width + 20) - 4, ((j + 1) * width + 160) - 4, 8, 8);
                dots[i][j].setFill(Paint.valueOf("#34495e"));
                dots[i][j].setStroke(Paint.valueOf("#34495e"));
                dots[i][j].setArcHeight(6);
                dots[i][j].setArcWidth(6);
            }
        return dots;
    }

    public static void changeColor(int i, int j, String color)
    {
        tiles[i][j].setFill(Paint.valueOf(color));
        Sound.soundWinBox();
    }

}

