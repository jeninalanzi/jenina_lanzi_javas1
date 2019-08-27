package com.trilogyed.tasker.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class Task {

    private int id;

    @NotEmpty(message = "You cannot leave description empty.")
    @Size(min = 3, max = 255, message = "Description can be a maximum of 255 chars.")
    private String description;

    @NotEmpty(message = "You cannot have an empty create date!")
    private LocalDate createDate;

    @NotEmpty(message = "You cannot have an empty due date!")
    private LocalDate dueDate;

    @Size(max = 50, message = "Category can be a maximum of 50 chars long.")
    private String category;

    // Getters, setters, toString, equals, hashCode
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(description, task.description) &&
                Objects.equals(createDate, task.createDate) &&
                Objects.equals(dueDate, task.dueDate) &&
                Objects.equals(category, task.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, createDate, dueDate, category);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", dueDate=" + dueDate +
                ", category='" + category + '\'' +
                '}';
    }
}
