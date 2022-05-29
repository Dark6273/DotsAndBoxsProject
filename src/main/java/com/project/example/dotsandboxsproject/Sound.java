package com.project.example.dotsandboxsproject;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Sound {
    public static void soundWinBox()
    {
        Media sound = new Media(new File("src/main/resources/sound/winBox.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public static void soundWin()
    {
        Media sound = new Media(new File("src/main/resources/sound/winGame.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public static void soundStartGame()
    {
        Media sound = new Media(new File("src/main/resources/sound/startGame.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
}
