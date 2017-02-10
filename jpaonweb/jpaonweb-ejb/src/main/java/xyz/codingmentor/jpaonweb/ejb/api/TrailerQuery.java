package xyz.codingmentor.jpaonweb.ejb.api;

import java.util.List;
import xyz.codingmentor.jpaonweb.ejb.entity.Trailer;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;

/**
 *
 * @author blazefury
 */
public interface TrailerQuery {

    List<Trailer> selectTrailerByFilm(String titleOfFilm) throws RepositoryException;

}
