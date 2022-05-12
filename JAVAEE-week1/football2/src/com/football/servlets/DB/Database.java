package com.football.servlets.DB;

import com.football.servlets.player.SinglePlayer;

import java.util.ArrayList;

public class Database {
        private static ArrayList<SinglePlayer> allPlayers = new ArrayList<>();

        public static void addPlayer (SinglePlayer player){
            allPlayers.add(player);
        }

        public static ArrayList<SinglePlayer> getAllPlayers(){
            return allPlayers;
        }
}
