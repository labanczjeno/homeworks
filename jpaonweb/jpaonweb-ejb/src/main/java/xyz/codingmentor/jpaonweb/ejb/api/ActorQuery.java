package xyz.codingmentor.jpaonweb.ejb.api;

import java.util.List;
import xyz.codingmentor.jpaonweb.ejb.entity.Actor;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;

/**
 *
 * @author blazefury
 */
public interface ActorQuery {

    List<Actor> selectActorByHisFilms(String title) throws RepositoryException;

    List<Actor> selectActorByHisName(String firstName, String lastName) throws RepositoryException;

    List<Actor> selectActorByHisNationality(String nationality) throws RepositoryException;

}
