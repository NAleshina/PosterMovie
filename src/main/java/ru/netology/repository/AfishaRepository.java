package ru.netology.repository;

import ru.netology.domain.Movie;

import java.util.ArrayList;

public class AfishaRepository {
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    public AfishaRepository (){}

    public Movie[] findAll() {
        Movie[] allFilm = new Movie[movies.size()];
        for (int i = 0; i <= movies.size() - 1; i++) {
            allFilm[i] = movies.get(i);
        }
        return allFilm;
    }

    public void save(Movie film) {
        movies.add(film);
    }

    public Movie findById(String id) {
        Movie idFilm = null;
        for (int i = 0; i <= movies.size() - 1; i++) {
            Movie film = movies.get(i);
            if (film.getId() == id) {
                idFilm = film;
            }
        }
        return idFilm;
    }

    public void removeById(String id) {
        Movie film = findById(id);
        movies.remove(film);

    }

    public void removeAll() {
        movies.clear();
    }
}
