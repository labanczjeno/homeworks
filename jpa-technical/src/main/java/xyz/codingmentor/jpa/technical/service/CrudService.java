package xyz.codingmentor.jpa.technical.service;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import xyz.codingmentor.jpa.technical.exception.RepositoryException;
import xyz.codingmentor.jpa.technical.entity.Product;

/**
 *
 * @author blazefury
 */
public class CrudService {

    @Inject
    private CrudRepositoryService productRepositoryService;

    public CrudService() {
        //empty on purpose
    }

    public Product createProduct(int id) throws RepositoryException {
        return productRepositoryService.createProduct(id);
    }

    public Product findProductByID(Product id) throws RepositoryException {
        return productRepositoryService.findProductByID(id);
    }

    public void updateProduct(Product product) throws RepositoryException {
        productRepositoryService.updateProduct(product);
    }

    public void removeProductByID(Product id) throws RepositoryException {
        productRepositoryService.removeProductByID(id);
    }

    @PreDestroy
    private void close() {
        productRepositoryService.close();
    }

}
