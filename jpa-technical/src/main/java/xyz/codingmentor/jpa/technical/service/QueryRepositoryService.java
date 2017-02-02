package xyz.codingmentor.jpa.technical.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import xyz.codingmentor.jpa.technical.api.QueryRepository;
import xyz.codingmentor.jpa.technical.exception.RepositoryException;
import xyz.codingmentor.jpa.technical.entity.Part;
import xyz.codingmentor.jpa.technical.entity.Product;
import xyz.codingmentor.jpa.technical.entity.Technican;

/**
 *
 * @author blazefury
 */
public class QueryRepositoryService implements QueryRepository{

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private final EntityTransaction entityTransaction;
    
    public QueryRepositoryService(){
        entityManagerFactory=Persistence.createEntityManagerFactory("jpatechnicalPU");
        entityManager=entityManagerFactory.createEntityManager();
        entityTransaction=entityManager.getTransaction();
    }

    @Override
    public List<Product> getProductsStartsWithSomething(String start) throws RepositoryException {
        String selectQuery = "SELECT p FROM Products p WHERE p.productName LIKE :productName";
        TypedQuery<Product> query = entityManager.createQuery(selectQuery, Product.class);
        query.setParameter("productName", start + "%");
        List<Product> products = query.getResultList();
        for (Product p : products) {
            entityManager.refresh(p);
        }
        return products;
    }

    @Override
    public Technican getTechByID(int id) throws RepositoryException {
        String selectQuery = "SELECT t FROM Technicians t WHERE t.Id LIKE :Id";
        TypedQuery<Technican> query = entityManager.createQuery(selectQuery, Technican.class);
        query.setParameter("Id", id);
        return query.getSingleResult();
    }

    @Override
    public Part getCheapestPart() throws RepositoryException {
        String selectQuery = "SELECT p.productID, MIN(p.unitPrice) FROM Parts p";
        TypedQuery<Part> query = entityManager.createQuery(selectQuery, Part.class);
        return query.getSingleResult();      
    }

    @Override
    public void fireTechnicianById(int id) throws RepositoryException {
        String deleteQuery = "DELETE FROM Technicians t WHERE t.Id LIKE :Id";
        TypedQuery<Technican> query = entityManager.createQuery(deleteQuery, Technican.class);
        query.setParameter("Id", id);
        entityTransaction.begin();
        query.executeUpdate();
        entityTransaction.commit();
    }

    @Override
    public void hireTechnican(String name) throws RepositoryException {
        String updateQuery = "INSERT INTO Technicians t VALUES(':name')";
        TypedQuery<Technican> query = entityManager.createQuery(updateQuery, Technican.class);
        query.setParameter(":name", name);
        entityTransaction.begin();
        query.executeUpdate();
        entityTransaction.commit();
    }

    @Override
    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
