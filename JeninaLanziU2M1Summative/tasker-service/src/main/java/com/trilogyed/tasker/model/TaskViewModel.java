package com.trilogyed.tasker.model;

import java.time.LocalDate;
import java.util.Objects;

public class TaskViewModel {

    // POJO
    private int id;
    private String description;
    private LocalDate createDate;
    private LocalDate dueDate;
    private String category;
    private String advertisement;

    // Getters, setters, equals, hashCode, toString
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskViewModel that = (TaskViewModel) o;
        return getId() == that.getId() &&
                getDescription().equals(that.getDescription()) &&
                getCreateDate().equals(that.getCreateDate()) &&
                getDueDate().equals(that.getDueDate()) &&
                getCategory().equals(that.getCategory()) &&
                getAdvertisement().equals(that.getAdvertisement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getCreateDate(), getDueDate(), getCategory(), getAdvertisement());
    }

    @Override
    public String toString() {
        return "TaskViewModel{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", dueDate=" + dueDate +
                ", category='" + category + '\'' +
                ", advertisement='" + advertisement + '\'' +
                '}';
    }
}
