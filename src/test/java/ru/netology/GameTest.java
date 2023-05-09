package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testFirstPlayerStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Макс", 100);
        Player player2 = new Player(2, "Серж", 50);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Макс", "Серж");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayerStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Макс", 100);
        Player player2 = new Player(2, "Серж", 50);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Серж", "Макс");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenDraw() {
        Game game = new Game();
        Player player1 = new Player(1, "Макс", 50);
        Player player2 = new Player(2, "Серж", 50);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Серж", "Макс");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstPlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Макс", 50);
        Player player2 = new Player(2, "Серж", 50);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Вася", "Макс")
        );
    }

    @Test
    public void testSecondPlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Макс", 50);
        Player player2 = new Player(2, "Серж", 50);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Макс", "Максим")
        );
    }

    @Test
    public void testBothPlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Макс", 50);
        Player player2 = new Player(2, "Серж", 50);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Рома", "Максим")
        );
    }

}