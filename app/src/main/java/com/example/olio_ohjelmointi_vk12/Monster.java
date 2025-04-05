package com.example.olio_ohjelmointi_vk12;

public abstract class Monster {
    public Monster(int monsterMaxLife, String monsterName) {
        this.maxLife = monsterMaxLife;
        this.life = monsterMaxLife;
        this.name = monsterName;
    }

    private String name;
    private int life;
    private int maxLife;
    public void takeDamage(int damage) {
        if (damage <= life)
            life = life - damage;
        else
            life = 0;
    }
    public int getLife(){
        return this.life;
    }
    public String getName(){
        return this.name;
    }
    public int getMaxLife(){
        return  this.maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

}
