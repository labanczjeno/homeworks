package xyz.codingmentor.jpaonweb.ejb.api;

import xyz.codingmentor.jpaonweb.ejb.entity.Actor;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;

/**
 *
 * @author blazefury
 */
public interface ActorCRUDRepository {

    void persist(Actor actor) throws RepositoryException;

    Actor find(int id) throws RepositoryException;

    Actor merge(Actor entity) throws RepositoryException;

    void remove(int id) throws RepositoryException;
}
