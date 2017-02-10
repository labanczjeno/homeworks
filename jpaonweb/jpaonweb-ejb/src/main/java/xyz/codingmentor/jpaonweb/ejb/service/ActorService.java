package xyz.codingmentor.jpaonweb.ejb.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jpaonweb.ejb.entity.Actor;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;
import xyz.codingmentor.jpaonweb.ejb.repository.ActorRepository;

/**
 *
 * @author blazefury
 */
@Stateless
public class ActorService {

    private ActorRepository actorRepository;

    @Inject
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public ActorService() {
        //empty on purpose
    }

    public Actor getActorById(int id) throws RepositoryException {
        return actorRepository.find(id);
    }

    public void addActor(Actor actor) throws RepositoryException {
        actorRepository.persist(actor);
    }

    public Actor editActor(Actor actor) throws RepositoryException {
        return actorRepository.merge(actor);
    }

    public void removeActor(int id) throws RepositoryException {
        actorRepository.remove(id);
    }

    public List<Actor> selectActorByHisFilms(String title) throws RepositoryException {
        return actorRepository.selectActorByHisFilms(title);
    }

    public List<Actor> selectActorByHisName(String firstName, String lastName) throws RepositoryException {
        return actorRepository.selectActorByHisName(firstName, lastName);
    }

    public List<Actor> selectActorByHisNationality(String nationality) throws RepositoryException {
        return actorRepository.selectActorByHisNationality(nationality);
    }

}
