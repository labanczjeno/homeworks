package xyz.codingmentor.jpa.technical.api;

import xyz.codingmentor.jpa.technical.exception.RepositoryException;
import xyz.codingmentor.jpa.technical.entity.Product;

/**
 *
 * @author blazefury
 */
public interface CrudRepository {

    Product createProduct(int id) throws RepositoryException;

    Product findProductByID(Product id) throws RepositoryException;

    void updateProduct(Product product) throws RepositoryException;

    void removeProductByID(Product id) throws RepositoryException;

    void close();
}
