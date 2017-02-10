package xyz.codingmentor.jpaonweb.ejb.api;

import xyz.codingmentor.jpaonweb.ejb.entity.Trailer;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;

/**
 *
 * @author blazefury
 */
public interface TrailerCRUDRepository {

    void persist(Trailer trailer) throws RepositoryException;

    Trailer find(int id) throws RepositoryException;

    Trailer merge(Trailer trailer) throws RepositoryException;

    void remove(int id) throws RepositoryException;
}
