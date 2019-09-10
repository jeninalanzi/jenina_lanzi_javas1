package com.company.JeninaLanziU1Capstone.dao;

import com.company.JeninaLanziU1Capstone.model.Game;

import java.util.List;

public interface GameDao {

    /*
    Perform standard CRUD operations for Games
    Search for Games by Studio
    Search for Games by ESRB Rating
    Search for Games by Title
     */

    Game addGame(Game game);

    Game getGame(int id);

    List<Game> getAllGames();

    List<Game> searchByStudio(String studio);

    List<Game> searchByEsrbRating(String esrb);

    List<Game> searchByTitle(String title);

    void updateGame(Game game);

    void deleteGame(int id);
}
