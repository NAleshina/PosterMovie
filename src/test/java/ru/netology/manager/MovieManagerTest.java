package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
    private Movie first = new Movie("1", "first", "Der Fall Collini", "thriller");
    private Movie second = new Movie("2", "second", "Red Shoes", "fantasy");
    private Movie third = new Movie("3", "third", "Metti la nonna in freezer", "comedy");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldAddMovie(){
        Movie[] actual = manager.get10();
        Movie[] expected = new Movie[]{third, second, first};
        assertArrayEquals(expected, actual);
    }

}