package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;
    private Movie first = new Movie("1", "first", "Der Fall Collini", "thriller");
    private Movie second = new Movie("2", "second", "Red Shoes", "fantasy");
    private Movie third = new Movie("3", "third", "Metti la nonna in freezer", "comedy");

    @Test
    void shouldGet10Movies() {
        Movie[] returned = new Movie[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.get10();
        Movie[] expected = new Movie[]{third, second, first};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void shouldAddMovie() {
        doNothing().when(repository).save(first);
        Movie[] expected = new Movie[]{first};
        manager.add(first);
        Movie[] actual = new Movie[]{first};
        assertArrayEquals(expected, actual);
        verify(repository).save(first);
    }

}