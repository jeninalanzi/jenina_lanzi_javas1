package com.company.JeninaLanziU1Capstone.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public class Game extends Item {

    @NotEmpty(message = "You must supply a title for the game.")
    @Size(max = 50, message = "Title can only be a max of 50 chars.")
    private String title;

    @NotEmpty(message = "You must supply a rating for the game.")
    @Size(max = 50, message = "This field cannot exceed 50 chars.")
    private String esrbRating;

    @NotEmpty(message = "You must supply a description of the game.")
    @Size(max = 255, message = "Description can be up to 255 chars long.")
    private String description;

    @NotEmpty(message = "You must supply a studio for the game.")
    @Size(max = 50, message = "Studio cannot exceed 50 chars.")
    private String studio;

    // Getters, setters, equals, hashCode, toString
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Game game = (Game) o;
        return getTitle().equals(game.getTitle()) &&
                getEsrbRating().equals(game.getEsrbRating()) &&
                getDescription().equals(game.getDescription()) &&
                getStudio().equals(game.getStudio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTitle(), getEsrbRating(), getDescription(), getStudio());
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", esrbRating='" + esrbRating + '\'' +
                ", description='" + description + '\'' +
                ", studio='" + studio + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
