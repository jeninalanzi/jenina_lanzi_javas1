package com.company;

import com.company.interfaces.Alarm;
import com.company.interfaces.Clock;

public class DigitalClock implements Clock, Alarm {

    public void displayTime() {}

    public void timer(int hour, int minute) {}

    public void sound() {}
}
