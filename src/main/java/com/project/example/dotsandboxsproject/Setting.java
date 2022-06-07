package com.project.example.dotsandboxsproject;

import java.io.File;
import java.io.IOException;

import org.ini4j.*;

public class Setting {
    private static Ini getIni() throws IOException {
        File file = new File("src/main/resources/setting.ini");
        if (!file.exists()) {
            try {
                file.createNewFile();
                defaultSetting();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new Ini(file);
    }

    public static void defaultSetting() throws IOException {
        Ini ini = getIni();
        ini.putComment("Comment", "This is a comment");
        ini.put("Author", "name", "Mahdi Khosravi");
        ini.put("Author", "email", "mahdi.khosravi6273@gmail.com");
        ini.put("Author", "Github", "https://github.com/Dark6273");

        ini.put("Setting", "music", "true");
        ini.put("Setting", "sound", "true");

        ini.put("Players", "name_player_1", "Player 1");
        ini.put("Players", "color_player_1", "#e74c3c");
        ini.put("Players", "name_player_2", "Player 2");
        ini.put("Players", "color_player_2", "#1abc9c");

        ini.store();
        System.out.println("Default setting created");
    }

    private static void updateSetting(String section, String option, String value) throws IOException {
        Ini ini = getIni();
        ini.put(section, option, value);
        ini.store();
    }

    public static void updatePlayer(String[] namePlayers, String[] colorPlayers) throws IOException {
        for (int i = 0; i < namePlayers.length; i++) {
            updateSetting("Players", "name_player_" + (i + 1), namePlayers[i]);
            updateSetting("Players", "color_player_" + (i + 1), colorPlayers[i]);
        }
    }

    public static void updateSound(boolean sound, boolean music) throws IOException {
        updateSetting("Setting", "music", String.valueOf(music));
        updateSetting("Setting", "sound", String.valueOf(sound));
    }

    public static String[] getNamePlayers() throws IOException {
        Ini ini = getIni();
        String[] namePlayers = new String[2];
        namePlayers[0] = ini.get("Players", "name_player_1");
        namePlayers[1] = ini.get("Players", "name_player_2");
        return namePlayers;
    }

    public static String[] getColorPlayers() throws IOException {
        Ini ini = getIni();
        String[] colorPlayers = new String[2];
        colorPlayers[0] =  ini.get("Players", "color_player_1");
        colorPlayers[1] =  ini.get("Players", "color_player_2");
        return colorPlayers;
    }

    public static Boolean getMusic() throws IOException {
        Ini ini = getIni();
        return Boolean.valueOf(ini.get("Setting", "music"));
    }

    public static Boolean getSound() throws IOException {
        Ini ini = getIni();
        return Boolean.valueOf(ini.get("Setting", "sound"));
    }

//    public static void main(String[] args) throws IOException {
//        System.out.println(getNamePlayers()[0]);
//        System.out.println(getNamePlayers()[1]);
//        System.out.println(getColorPlayers()[0]);
//        System.out.println(getColorPlayers()[1]);
//        System.out.println(getMusic());
//        System.out.println(getSound());
//    }
}
