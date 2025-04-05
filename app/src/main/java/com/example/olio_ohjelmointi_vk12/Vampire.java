package com.example.olio_ohjelmointi_vk12;

import java.util.Random;

public class Vampire extends Monster {

    private static final String[] names = { "Nero", "Ceasar", "Augustus" };
    private static final Random rand = new Random();

    public Vampire(int maxLife, String name) {
        super(maxLife, name);
    }
    public static String getRandomName() {
        int i = rand.nextInt(names.length);
        return names[i];
    }
}

