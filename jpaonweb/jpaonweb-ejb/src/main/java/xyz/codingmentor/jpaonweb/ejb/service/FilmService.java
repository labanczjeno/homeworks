package xyz.codingmentor.jpaonweb.ejb.service;

import java.util.List;
import javax.inject.Inject;
import xyz.codingmentor.jpaonweb.ejb.entity.Film;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;
import xyz.codingmentor.jpaonweb.ejb.repository.FilmRepository;

/**
 *
 * @author blazefury
 */
public class FilmService {

    private FilmRepository filmRepository;

    @Inject
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public FilmService() {
        //empty on purpose
    }

    public Film getFilmById(int id) throws RepositoryException {
        return filmRepository.find(id);
    }

    public void addFilm(Film film) throws RepositoryException {
        filmRepository.persist(film);
    }

    public Film editFilm(Film film) throws RepositoryException {
        return filmRepository.merge(film);
    }

    public void removeFilm(int id) throws RepositoryException {
        filmRepository.remove(id);
    }

    public List<Film> selectFilmByCategory(int categoryId) throws RepositoryException {
        return filmRepository.selectFilmByCategory(categoryId);
    }

    public List<Film> selectFilmByTitle(String title) throws RepositoryException {
        return filmRepository.selectFilmByTitle(title);
    }
}
