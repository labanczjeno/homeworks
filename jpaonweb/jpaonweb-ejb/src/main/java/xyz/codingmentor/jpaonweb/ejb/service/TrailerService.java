package xyz.codingmentor.jpaonweb.ejb.service;

import java.util.List;
import javax.inject.Inject;
import xyz.codingmentor.jpaonweb.ejb.entity.Trailer;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;
import xyz.codingmentor.jpaonweb.ejb.repository.TrailerRepository;

/**
 *
 * @author blazefury
 */
public class TrailerService {

    private TrailerRepository trailerRepository;

    public TrailerService() {
        //empty on purpose
    }

    @Inject
    public TrailerService(TrailerRepository trailerRepository) {
        this.trailerRepository = trailerRepository;
    }

    public Trailer getTrailerById(int id) throws RepositoryException {
        return trailerRepository.find(id);
    }

    public void addTrailer(Trailer trailer) throws RepositoryException {
        trailerRepository.persist(trailer);
    }

    public Trailer editTrailer(Trailer trailer) throws RepositoryException {
        return trailerRepository.merge(trailer);
    }

    public void removeTrailer(int id) throws RepositoryException {
        trailerRepository.remove(id);
    }

    public List<Trailer> selectTrailerByFilm(String titleOfFilm) throws RepositoryException {
        return trailerRepository.selectTrailerByFilm(titleOfFilm);
    }
}
