package com.example.olio_ohjelmointi_vk12;

import java.util.Random;

public class GameManager {

    private static GameManager instance;
    private Player player;

    private Monster latestMonster;

    private Random rand = new Random();

    private GameManager() {
        player = new Player();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public Player getPlayer() {
        return this.player;
    }


    public Monster generateMonster() {
        int n = rand.nextInt(10);
        Monster newMonster;

        if (n > 5) {
            newMonster = new Vampire(rand.nextInt(100), Vampire.getRandomName());
        } else newMonster = new Skeleton(rand.nextInt(100), Skeleton.getRandomName());

        latestMonster = newMonster;
        return newMonster;
    }
    public Monster getLatestMonster() {
        return latestMonster;
    }
}
