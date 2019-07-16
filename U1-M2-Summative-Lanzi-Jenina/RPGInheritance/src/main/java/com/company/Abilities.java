package com.company;

public interface Abilities {

    // If inherited, Characters must implement the following methods:
    public void run();

    public int attack(Character opponent);

    public int heal(Character x);

    public void decreaseHealth(Character opponent);

    public void increaseStamina(int increment);

    public void decreaseStamina(int decrement);
}
