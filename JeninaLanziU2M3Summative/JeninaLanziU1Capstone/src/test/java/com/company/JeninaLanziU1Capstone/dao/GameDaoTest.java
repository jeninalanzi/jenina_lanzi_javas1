package com.company.JeninaLanziU1Capstone.dao;

import com.company.JeninaLanziU1Capstone.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoTest {

    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() throws Exception {
        List<Game> gList = gameDao.getAllGames();
        for (Game g : gList) {
            gameDao.deleteGame(g.getId());
        }
    }

    @Test
    public void addGetDeleteGame() {

        Game game = new Game();
        game.setTitle("Resident Evil 4");
        game.setEsrbRating("M");
        game.setDescription("Classic survival-horror action game returns with all-new characters, controls, and storylines.");
        game.setPrice(new BigDecimal("16.98"));
        game.setStudio("Capcom");
        game.setQuantity(30);

        game = gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getId());
        assertEquals(game1, game);
    }

    @Test
    public void updateGame() {

        Game game = new Game();
        game.setTitle("Resident Evil 4");
        game.setEsrbRating("M");
        game.setDescription("Classic survival-horror action game returns with all-new characters, controls, and storylines.");
        game.setPrice(new BigDecimal("16.98"));
        game.setStudio("Capcom");
        game.setQuantity(30);

        game = gameDao.addGame(game);

        game.setTitle("Clock Tower 3");
        game.setPrice(new BigDecimal("14.50"));
        game.setQuantity(10);

        gameDao.updateGame(game);

        Game game1 = gameDao.getGame(game.getId());
        assertEquals(game1, game);
    }

    @Test
    public void getAllGames() {

        Game game = new Game();
        game.setTitle("Resident Evil 4");
        game.setEsrbRating("M");
        game.setDescription("Classic survival-horror action game returns with all-new characters, controls, and storylines.");
        game.setPrice(new BigDecimal("16.98"));
        game.setStudio("Capcom");
        game.setQuantity(30);

        Game game1 = new Game();
        game1.setTitle("Mario Party 9");
        game1.setEsrbRating("E");
        game1.setDescription("A party video game for the Wii, the ninth installment in the Mario Party series.");
        game1.setPrice(new BigDecimal("42.98"));
        game1.setStudio("Nintendo");
        game1.setQuantity(15);

        game = gameDao.addGame(game);
        game1 = gameDao.addGame(game1);

        List<Game> allGames = gameDao.getAllGames();

        assertEquals(allGames.size(), 2);
    }

    @Test
    public void getGamesBySearch() {

        Game game = new Game();
        game.setTitle("Resident Evil 4");
        game.setEsrbRating("M");
        game.setDescription("Classic survival-horror action game returns with all-new characters, controls, and storylines.");
        game.setPrice(new BigDecimal("16.98"));
        game.setStudio("Capcom");
        game.setQuantity(30);

        Game game1 = new Game();
        game1.setTitle("Mario Party 9");
        game1.setEsrbRating("E");
        game1.setDescription("A party video game for the Wii, the ninth installment in the Mario Party series.");
        game1.setPrice(new BigDecimal("42.98"));
        game1.setStudio("Nintendo");
        game1.setQuantity(15);

        Game game2 = new Game();
        game2.setTitle("Bomberman 64");
        game2.setEsrbRating("E");
        game2.setDescription("One of the best games to ever exist.");
        game2.setPrice(new BigDecimal("394.97"));
        game2.setStudio("Nintendo");
        game2.setQuantity(2);

        game = gameDao.addGame(game);
        game1 = gameDao.addGame(game1);
        game2 = gameDao.addGame(game2);

        List<Game> allGamesByStudio = gameDao.searchByStudio("Nintendo");
        assertEquals(allGamesByStudio.size(), 2);

        allGamesByStudio = gameDao.searchByStudio("Midway");
        assertEquals(allGamesByStudio.size(), 0);

        List<Game> allGamesByRating = gameDao.searchByEsrbRating("E");
        assertEquals(allGamesByRating.size(), 2);

        allGamesByRating = gameDao.searchByEsrbRating("T");
        assertEquals(allGamesByRating.size(), 0);

        List<Game> allGamesByTitle = gameDao.searchByTitle("Resident Evil 4");
        assertEquals(allGamesByTitle.size(), 1);

        allGamesByTitle = gameDao.searchByTitle("Mortal Kombat");
        assertEquals(allGamesByTitle.size(), 0);
    }
}
