package xyz.codingmentor.jpa.technical.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import xyz.codingmentor.jpa.technical.exception.RepositoryException;
import xyz.codingmentor.jpa.technical.entity.Product;
import xyz.codingmentor.jpa.technical.api.CrudRepository;

/**
 *
 * @author blazefury
 */
@Stateless
public class CrudRepositoryService implements CrudRepository {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private final EntityTransaction entityTransaction;

    public CrudRepositoryService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatechnicalPU");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @Override
    public Product createProduct(int id) throws RepositoryException {
        Product product = new Product();
        product.setProductID(id);
        entityTransaction.begin();
        entityManager.persist(product);
        entityTransaction.commit();
        return product;
    }

    @Override
    public Product findProductByID(Product id) throws RepositoryException {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            return product;
        }
        return null;
    }

    @Override
    public void updateProduct(Product product) throws RepositoryException {
        entityTransaction.begin();
        entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void removeProductByID(Product id) throws RepositoryException {
        entityTransaction.begin();
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(id);
        }
        entityTransaction.commit();
    }

    @Override
    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
