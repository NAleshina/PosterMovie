package ru.netology.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    private Movie first = new Movie("1", "first", "Der Fall Collini", "thriller");
    private Movie second = new Movie("2", "second", "Red Shoes", "fantasy");
    private Movie third = new Movie("3", "third", "Metti la nonna in freezer", "comedy");

    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @AfterEach
    void printResult(){
        Movie[] actual = repository.findAll();
        for (int i = 0; i < actual.length; i++){
            Movie film = actual[i];
            System.out.println("film imageUrl: " + film.getImageUrl());
        }
    }

    @Test
    public void shouldFinedAllMovie() {
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third};
        assertArrayEquals(expected, actual);
        System.out.println("shouldFinedAllMovie");
    }

    @Test
    public void shouldSaveMovie() {
        Movie fourth = new Movie("4", "fourth", "Star Wars: The Rise of Skywalker", "sci-fi");
        repository.save(fourth);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth};
        assertArrayEquals(expected, actual);
        System.out.println("shouldSaveMovie");
    }

    @Test
    public void shouldFindByIdMovie(){
        Movie actual = repository.findById("2");
        assertEquals(second, actual);
        System.out.println("shouldFindByIdMovie");
    }

    @Test
    public void shouldRemoveByIdMovie(){
        repository.removeById("2");
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, third};
        assertArrayEquals(expected, actual);
        System.out.println("shouldRemoveByIdMovie");
    }

    @Test
    public void shouldRemoveAllMovies(){
        repository.removeAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
        System.out.println("shouldRemoveAllMovies");
    }
}
