package com.project.example.dotsandboxsproject;

import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application {
    private static Player[] players;
    private static boolean turn = true;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Board board = new Board();
        primaryStage.setResizable(false);
        board.board(primaryStage);
    }

    public static void setPlayers(Player[] player) {
        players = player;
    }

    public  Player[] getPlayers() {
        return players;
    }

    public static Player currentPlayer(boolean status) {
        if (status)
            turn = !turn;
        if (turn) return players[0];
        else return players[1];
    }
}
