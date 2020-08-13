package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerNonDefaultTest {
    private MovieManager manager = new MovieManager(2);
    private Movie first = new Movie("1", "first", "Der Fall Collini", "thriller");
    private Movie second = new Movie("2", "second", "Red Shoes", "fantasy");
    private Movie third = new Movie("3", "third", "Metti la nonna in freezer", "comedy");

    @Test
    void shouldAddMovieAndGet() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        Movie[] actual = manager.get10();
        Movie[] expected = new Movie[]{third, second};
        assertArrayEquals(expected, actual);
    }

}