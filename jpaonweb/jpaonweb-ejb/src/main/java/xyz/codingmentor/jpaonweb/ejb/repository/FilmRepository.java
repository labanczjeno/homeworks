package xyz.codingmentor.jpaonweb.ejb.repository;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import xyz.codingmentor.jpaonweb.ejb.api.FilmCRUDRepository;
import xyz.codingmentor.jpaonweb.ejb.api.FilmQuery;
import xyz.codingmentor.jpaonweb.ejb.entity.Film;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;

/**
 *
 * @author blazefury
 */
@Stateless
public class FilmRepository implements FilmCRUDRepository, FilmQuery {

    @PersistenceContext(unitName = "hollywoodPU")
    private EntityManager entityManager;

    @Override
    public void persist(Film film) throws RepositoryException {
        entityManager.persist(film);
    }

    @Override
    public Film find(int id) throws RepositoryException {
        return entityManager.find(Film.class, id);
    }

    @Override
    public Film merge(Film film) throws RepositoryException {
        return entityManager.merge(film);
    }

    @Override
    public void remove(int id) throws RepositoryException {
        entityManager.remove(id);
    }

    @Override
    public List<Film> selectFilmByCategory(int categoryId) throws RepositoryException {
        String selectQuery = "SELECT f FROM film f JOIN f.category c WHERE c.categoryId = :categoryId";
        TypedQuery<Film> query = entityManager.createQuery(selectQuery, Film.class);
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    @Override
    public List<Film> selectFilmByTitle(String title) throws RepositoryException {
        String selectQuery = "SELECT f FROM film f WHERE f.title = :title";
        TypedQuery<Film> query = entityManager.createQuery(selectQuery, Film.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

}
