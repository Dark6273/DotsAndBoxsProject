package com.project.example.dotsandboxsproject;

import java.util.UUID;

public class Player {
    private String Name;
    private int Score = 0;
    private String Color;
    private final String Id;

    public Player(String name, String color)
    {
        this.Name = name;
        this.Color = color;
        this.Id = UUID.randomUUID().toString();
    }

    public String getName() {
        return Name;
    }

    public String getColor() {
        return Color;
    }

    public String getId() {
        return Id;
    }

    public int getScore() {
        return Score;
    }

    public void addScore()
    {
        this.Score += 1;
    }

    public void update(String name, String color)
    {
        this.Name = name;
        this.Color = color;
    }
}
