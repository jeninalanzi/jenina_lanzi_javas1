package com.company;

public class Warrior extends Character implements Abilities {
    // Initial values
    private int strength = 75;
    private int health = 100;
    private int stamina = 100;
    private int speed = 50;
    private int attackPower = 10;
    private int shieldStrength = 100;

    // Methods inherited & unique
    public void run() {
        System.out.println("Constable is running at " + speed + " speed.");
        decreaseStamina(4);
    }


    public int attack(Character opponent) {
        int result = opponent.getHealth() - this.getAttackPower();
        if (result <= opponent.getAttackPower()) {
            System.out.println("Quick, get some healing potions before " + opponent.getName() + " takes you out for good!");
        }
        return result;
    }

    public int heal(Character x) {
        int result = this.health = 100;
        increaseStamina(5);
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

    public void decreaseShieldStrength(int decrement) {
        shieldStrength = this.shieldStrength - decrement;
        System.out.println("Your shield has taken -" + decrement + " damage.");
    }
}
