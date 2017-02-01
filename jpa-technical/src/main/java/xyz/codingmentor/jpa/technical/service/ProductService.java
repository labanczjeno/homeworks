package xyz.codingmentor.jpa.technical.service;

import java.util.List;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import xyz.codingmentor.jpa.technical.api.RepositoryException;
import xyz.codingmentor.jpa.technical.entity.Part;
import xyz.codingmentor.jpa.technical.entity.Product;
import xyz.codingmentor.jpa.technical.entity.Technican;

/**
 *
 * @author blazefury
 */
public class ProductService {
    
    @Inject
    private ProductRepositoryService productRepositoryService;
    
    public ProductService() {
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
    
    public List<Product> getProductsStartsWithSomething(String name) throws RepositoryException {
        return productRepositoryService.getProductsStartsWithSomething(name);
    }
    
    public Technican getTechByID(int id) throws RepositoryException {
        return productRepositoryService.getTechByID(id);
    }
    
    public Part getCheapestPart() throws RepositoryException {
        return productRepositoryService.getCheapestPart();
    }
    
    public void fireTechnicianById(int id) throws RepositoryException {
        productRepositoryService.fireTechnicianById(id);
    }
    
    public void hireTechnican(String name) throws RepositoryException {
        productRepositoryService.hireTechnican(name);
    }
    
    @PreDestroy
    private void close() {
        productRepositoryService.close();
    }
    
}
