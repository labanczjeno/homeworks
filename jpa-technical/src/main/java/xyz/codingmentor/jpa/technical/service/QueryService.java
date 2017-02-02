package xyz.codingmentor.jpa.technical.service;

import java.util.List;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import xyz.codingmentor.jpa.technical.exception.RepositoryException;
import xyz.codingmentor.jpa.technical.entity.Part;
import xyz.codingmentor.jpa.technical.entity.Product;
import xyz.codingmentor.jpa.technical.entity.Technican;

/**
 *
 * @author blazefury
 */
public class QueryService {

    @Inject
    private QueryRepositoryService queryRepositoryService;

    public QueryService() {
        //empty on purpose
    }

    public List<Product> getProductsStartsWithSomething(String name) throws RepositoryException {
        return queryRepositoryService.getProductsStartsWithSomething(name);
    }

    public Technican getTechByID(int id) throws RepositoryException {
        return queryRepositoryService.getTechByID(id);
    }

    public Part getCheapestPart() throws RepositoryException {
        return queryRepositoryService.getCheapestPart();
    }

    public void fireTechnicianById(int id) throws RepositoryException {
        queryRepositoryService.fireTechnicianById(id);
    }

    public void hireTechnican(String name) throws RepositoryException {
        queryRepositoryService.hireTechnican(name);
    }

    @PreDestroy
    private void close() {
        queryRepositoryService.close();
    }

}
