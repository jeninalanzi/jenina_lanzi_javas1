package com.company;

public class Constable extends Character implements Abilities {
    // Initial values
    private int strength = 60;
    private int health = 100;
    private int stamina = 60;
    private int speed = 20;
    private int attackPower = 5;
    private String jurisdiction;

    // Methods inherited & unique
    public void run() {
        System.out.println("Constable is running at " + speed + " speed.");
        decreaseStamina(3);
    }

    public void arrest(Character opponent) {
        System.out.println("Constable has arrested " + opponent.getName() + ". They won't be able to make any moves for a while.");
    }

    public int attack(Character opponent) {
        int result = opponent.getHealth() - this.getAttackPower();
        System.out.println("Ouch! You've taken -" + opponent.getAttackPower() + " damage from " + opponent.getName() + ".");
        if (result <= opponent.getAttackPower()) {
            System.out.println("Quick, get some healing potions before " + opponent.getName() + " takes you out for good!");
        }
        return result;
    }

    public int heal(Character x) {
        int result = this.health = 100;
        increaseStamina(4);
        System.out.println("You're all healed");
        return result;
    }

    public void decreaseHealth(Character opponent) {
        int result = this.health - opponent.getAttackPower();
        System.out.println("Ouch! You've taken -" + opponent.getAttackPower() + " damage from " + opponent.getName() + ".");
        if (result <= opponent.getAttackPower()) {
            System.out.println("Quick, get some healing potions before " + opponent.getName() + " takes you out for good!");
        }
    }

    public void increaseStamina(int increment) {
        stamina = this.stamina + increment;
    }

    public void decreaseStamina(int decrement) {
        stamina = this.stamina - decrement;
    }
}
