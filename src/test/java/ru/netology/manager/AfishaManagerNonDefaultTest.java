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
class AfishaManagerNonDefaultTest {

    private AfishaRepository repository = mock(AfishaRepository.class);
    private AfishaManager manager = new AfishaManager(repository, 2);
    private Movie first = new Movie("1", "first", "Der Fall Collini", "thriller");
    private Movie second = new Movie("2", "second", "Red Shoes", "fantasy");
    private Movie third = new Movie("3", "third", "Metti la nonna in freezer", "comedy");

    @Test
    void shouldNonDefaultGet10Movies() {
        Movie[] returned = new Movie[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(first);
        Movie[] actual = manager.get10();
        Movie[] expected = new Movie[]{third, second};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}