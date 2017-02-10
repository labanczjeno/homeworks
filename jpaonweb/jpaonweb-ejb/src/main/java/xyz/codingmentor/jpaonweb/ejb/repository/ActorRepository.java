package xyz.codingmentor.jpaonweb.ejb.repository;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import xyz.codingmentor.jpaonweb.ejb.api.ActorCRUDRepository;
import xyz.codingmentor.jpaonweb.ejb.api.ActorQuery;
import xyz.codingmentor.jpaonweb.ejb.entity.Actor;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;

/**
 *
 * @author blazefury
 */
@Stateless
public class ActorRepository implements ActorCRUDRepository, ActorQuery {

    @PersistenceContext(unitName = "hollywoodPU")
    private EntityManager entityManager;

    @Override
    public void persist(Actor actor) throws RepositoryException {
        entityManager.persist(actor);
    }

    @Override
    public Actor find(int id) throws RepositoryException {
        return entityManager.find(Actor.class, id);
    }

    @Override
    public Actor merge(Actor entity) throws RepositoryException {
        return entityManager.merge(entity);
    }

    @Override
    public void remove(int id) throws RepositoryException {
        entityManager.remove(find(id));
    }

    @Override
    public List<Actor> selectActorByHisFilms(String title) throws RepositoryException {
        String selectQuery = "SELECT a FROM actor a JOIN a.films f WHERE f.title = :title";
        TypedQuery<Actor> query = entityManager.createQuery(selectQuery, Actor.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Override
    public List<Actor> selectActorByHisName(String firstName, String lastName) throws RepositoryException {
        String selectQuery = "SELECT a FROM actor a WHERE a.firstName LIKE :firstName AND a.lastName LIKE :lastName";
        TypedQuery<Actor> query = entityManager.createQuery(selectQuery, Actor.class);
        query.setParameter("firname", firstName);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<Actor> selectActorByHisNationality(String nationality) throws RepositoryException {
        String selectQuery = "SELECT a FROM actor a WHERE a.nationality LIKE :nationality";
        TypedQuery<Actor> query = entityManager.createQuery(selectQuery, Actor.class);
        query.setParameter("nationality", nationality);
        return query.getResultList();
    }

}
