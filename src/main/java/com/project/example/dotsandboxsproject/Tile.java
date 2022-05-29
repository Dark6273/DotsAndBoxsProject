package com.project.example.dotsandboxsproject;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    public Tile(int i, int i1, int width, int width1) {
        super(i, i1, width, width1);
    }
    private static Tile[][] tiles;

    public static Tile[][] tile(int size)
    {
        Tile[][] tile = new Tile[size][size];
        int i = 0, j = 0, width = 460 / (size + 2);
        for (i = 0; i < size; i++)
            for (j = 0; j < size; j++)
            {
                tile[i][j] = new Tile(((i + 1) * width + 20), ((j + 1) * width + 160), width, width);
                tile[i][j].setFill(Color.TRANSPARENT);
                tile[i][j].setStroke(Color.WHITE);
            }
        tiles = tile;
        return tile;
    }

    public static void changeColor(int i, int j, String color)
    {
        tiles[i][j].setFill(Paint.valueOf(color));
    }
}

