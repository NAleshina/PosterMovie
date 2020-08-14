package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import java.util.ArrayList;

public class AfishaManager {
  private AfishaRepository repository;
  private int maxGet = 10;

  public AfishaManager(AfishaRepository repository, int maxGet) {
    this.repository = repository;
    this.maxGet = maxGet;
  }

  public AfishaManager(AfishaRepository repository) {
    this.repository = repository;
  }

  public AfishaManager() {}

  public void add(Movie film) {repository.save(film);}

  public Movie[] get10() {
    Movie[] films = repository.findAll();
    int maxGet1 = maxGet;
    if (films.length < maxGet1) {
      maxGet1 = films.length;
    }
    Movie[] newFilm = new Movie[maxGet1];

    for (int i = films.length - 1; i >= films.length - maxGet1; i--) {
      int newFilmIndex = films.length - 1 - i;
      newFilm[newFilmIndex] = films[i];
    }
    return newFilm;
  }
}
