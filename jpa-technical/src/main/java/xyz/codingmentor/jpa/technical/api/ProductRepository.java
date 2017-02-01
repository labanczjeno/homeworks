package xyz.codingmentor.jpa.technical.api;

import java.util.List;
import xyz.codingmentor.jpa.technical.entity.Part;
import xyz.codingmentor.jpa.technical.entity.Product;
import xyz.codingmentor.jpa.technical.entity.Technican;

/**
 *
 * @author blazefury
 */
public interface ProductRepository {

    Product createProduct(int id) throws RepositoryException;

    Product findProductByID(Product id) throws RepositoryException;

    void updateProduct(Product product) throws RepositoryException;

    void removeProductByID(Product id) throws RepositoryException;
    
    List<Product> getProductsStartsWithSomething(String name) throws RepositoryException;
    
    Technican getTechByID(int id) throws RepositoryException;
    
    Part getCheapestPart() throws RepositoryException;
            
    void fireTechnicianById(int id) throws RepositoryException;
    
    void hireTechnican(String name) throws RepositoryException;

    void close();
}
