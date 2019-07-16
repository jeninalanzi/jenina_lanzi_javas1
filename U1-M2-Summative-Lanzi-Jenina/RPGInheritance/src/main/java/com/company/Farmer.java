package com.company;

public class Farmer extends Character implements Abilities {
    // Initial values
    private int strength = 75;
    private int health = 100;
    private int stamina = 75;
    private int speed = 10;
    private int attackPower = 1;

    // Implement inherited methods & unique methods

    public void run() {
        System.out.println("Farmer is running at " + speed + " speed.");
        decreaseStamina(2);
    }

    public void plow() {
        decreaseStamina(1);
    }

    public void harvest() {
        decreaseStamina(1);
    }

    public int attack(Character opponent) {
        int result = opponent.getHealth() - this.getAttackPower();
        System.out.println("You attacked " + opponent.getName() + " and inflicted -" + opponent.getAttackPower() + "damage.");
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

    public void decreaseStamina (int decrement) {
        stamina = this.stamina - decrement;
    }
}
