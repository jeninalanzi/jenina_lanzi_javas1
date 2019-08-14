package com.company.JeninaLanziU1Capstone.controller;

import com.company.JeninaLanziU1Capstone.dao.GameDao;
import com.company.JeninaLanziU1Capstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class GameController {

    @Autowired
    GameDao gameDao;

    /*
    Perform standard CRUD operations for Games
    Search for Games by Studio
    Search for Games by ESRB Rating
    Search for Games by Title
    You must create a separate DAO for Games
     */

    // POST METHOD
    @RequestMapping(value = "/games", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game) {
        gameDao.addGame(game);
        return game;
    }

    // GET ALL GAMES
    @RequestMapping(value = "/games", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGames() {
        return gameDao.getAllGames();
    }

    // GET GAME BY ID
    @RequestMapping(value = "/games/{gameId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Game getGame(@PathVariable int gameId) {
        if (gameId < 1) {
            throw new IllegalArgumentException("Game ID must be greater than 0.");
        }
        return gameDao.getGame(gameId);
    }

    // PUT METHOD
    @RequestMapping(value = "/games/{gameId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game updateGame(@PathVariable int gameId, @RequestBody @Valid Game game) {
        for (Game g : gameDao.getAllGames()) {
            game.setId(gameId);
            gameDao.updateGame(game);
        }
        return gameDao.getGame(gameId);
    }

    // DELETE METHOD
    @RequestMapping(value = "/games/{gameId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteGame(@PathVariable int gameId) {
        gameDao.deleteGame(gameId);
    }

    // SEARCH BY STUDIO
    @RequestMapping(value = "/games/studio/{studio}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> searchGamesByStudio(@PathVariable String studio) {
        return gameDao.searchByStudio(studio);
    }

    // SEARCH BY ESRB RATING
    @RequestMapping(value = "/games/rating/{rating}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> searchGamesByRating(@PathVariable String rating) {
        return gameDao.searchByEsrbRating(rating);
    }

    // SEARCH BY TITLE
    @RequestMapping(value = "/games/title/{title}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> searchGamesByTitle(@PathVariable String title) {
        return gameDao.searchByTitle(title);
    }

}
