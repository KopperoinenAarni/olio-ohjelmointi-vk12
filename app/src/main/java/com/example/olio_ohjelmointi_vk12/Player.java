package com.example.olio_ohjelmointi_vk12;

import java.util.Random;

public class Player {

    public Player() {
    }

    private int damage;
    private int score;

    Random rand = new Random();

    public void attack(Monster target) {
        damage = rand.nextInt(20);
        target.takeDamage(this.damage);
        if (target.getLife() == 0) {
            this.score += 50;
        }

    }

    public int getScore() {
        return this.score;
    }
}
