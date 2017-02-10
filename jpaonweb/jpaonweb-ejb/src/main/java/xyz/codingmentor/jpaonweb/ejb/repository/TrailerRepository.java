package xyz.codingmentor.jpaonweb.ejb.repository;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import xyz.codingmentor.jpaonweb.ejb.api.TrailerCRUDRepository;
import xyz.codingmentor.jpaonweb.ejb.api.TrailerQuery;
import xyz.codingmentor.jpaonweb.ejb.entity.Trailer;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;

/**
 *
 * @author blazefury
 */
@Stateless
public class TrailerRepository implements TrailerCRUDRepository, TrailerQuery {

    @PersistenceContext(unitName = "hollywoodPU")
    private EntityManager entityManager;

    @Override
    public void persist(Trailer trailer) throws RepositoryException {
        entityManager.persist(trailer);
    }

    @Override
    public Trailer find(int id) throws RepositoryException {
        return entityManager.find(Trailer.class, id);
    }

    @Override
    public Trailer merge(Trailer trailer) throws RepositoryException {
        return entityManager.merge(trailer);
    }

    @Override
    public void remove(int id) throws RepositoryException {
        entityManager.remove(id);
    }

    @Override
    public List<Trailer> selectTrailerByFilm(String titleOfFilm) throws RepositoryException {
        String selectQuery = "SELECT t FROM trailer t JOIN t.film f WHERE f.title = :titleOfFilm";
        TypedQuery<Trailer> query = entityManager.createQuery(selectQuery, Trailer.class);
        query.setParameter("titleOfFilm", titleOfFilm);
        return query.getResultList();
    }

}
