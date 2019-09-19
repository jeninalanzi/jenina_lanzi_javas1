package com.trilogyed.retailapi.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class LevelUp {

    private int id;

    @Min(value = 1, message = "Customer ID cannot be zero")
    private int customerId;

    @Min(value = 1, message = "Points cannot be empty.")
    private int points;

    @NotNull(message = "Date cannot be empty.")
    private LocalDate memberDate;

    // Getters, setters, toString, equals, hashCode.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LocalDate getMemberDate() {
        return memberDate;
    }

    public void setMemberDate(LocalDate memberDate) {
        this.memberDate = memberDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LevelUp levelUp = (LevelUp) o;
        return getId() == levelUp.getId() &&
                getCustomerId() == levelUp.getCustomerId() &&
                getPoints() == levelUp.getPoints() &&
                getMemberDate().equals(levelUp.getMemberDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerId(), getPoints(), getMemberDate());
    }

    @Override
    public String toString() {
        return "LevelUp{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", points=" + points +
                ", memberDate=" + memberDate +
                '}';
    }
}
