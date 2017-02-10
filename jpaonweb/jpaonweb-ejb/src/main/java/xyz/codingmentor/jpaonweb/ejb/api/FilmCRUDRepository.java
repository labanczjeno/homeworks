package xyz.codingmentor.jpaonweb.ejb.api;

import xyz.codingmentor.jpaonweb.ejb.entity.Film;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;

/**
 *
 * @author blazefury
 */
public interface FilmCRUDRepository {

    void persist(Film film) throws RepositoryException;

    Film find(int id) throws RepositoryException;

    Film merge(Film film) throws RepositoryException;

    void remove(int id) throws RepositoryException;
}
