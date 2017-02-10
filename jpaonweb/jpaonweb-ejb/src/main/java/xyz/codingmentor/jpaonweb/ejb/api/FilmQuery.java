package xyz.codingmentor.jpaonweb.ejb.api;

import java.util.List;
import xyz.codingmentor.jpaonweb.ejb.entity.Film;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;

/**
 *
 * @author blazefury
 */
public interface FilmQuery {

    List<Film> selectFilmByCategory(int categoryId) throws RepositoryException;

    List<Film> selectFilmByTitle(String title) throws RepositoryException;

}
