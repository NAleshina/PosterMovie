package ru.netology.manager;

import ru.netology.domain.Movie;

import java.util.ArrayList;

public class MovieManager {
  private ArrayList<Movie> movies = new ArrayList<Movie>();
  private int maxGet = 10;

  public MovieManager(int maxGet) {
    this.maxGet = maxGet;
  }

  public MovieManager() {
  }

  public void add(Movie film) {
    movies.add(film);

  }

  public Movie[] get10() {
    int maxGet1 = maxGet;
    if (movies.size() < maxGet1) {
      maxGet1 = movies.size();
    }
    Movie[] newFilm = new Movie[maxGet1];

    for (int i = movies.size() - 1; i >= movies.size() - maxGet1; i--) {
      int newFilmIndex = movies.size() - 1 - i;
      newFilm[newFilmIndex] = movies.get(i);
    }
    return newFilm;
  }
}
