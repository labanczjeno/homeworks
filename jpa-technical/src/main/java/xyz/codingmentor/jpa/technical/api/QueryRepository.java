
package xyz.codingmentor.jpa.technical.api;

import xyz.codingmentor.jpa.technical.exception.RepositoryException;
import java.util.List;
import xyz.codingmentor.jpa.technical.entity.Part;
import xyz.codingmentor.jpa.technical.entity.Product;
import xyz.codingmentor.jpa.technical.entity.Technican;

/**
 *
 * @author blazefury
 */
public interface QueryRepository {

    List<Product> getProductsStartsWithSomething(String name) throws RepositoryException;
    
    Technican getTechByID(int id) throws RepositoryException;
    
    Part getCheapestPart() throws RepositoryException;
            
    void fireTechnicianById(int id) throws RepositoryException;
    
    void hireTechnican(String name) throws RepositoryException;

    void close();
    
}
