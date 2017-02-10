package xyz.codingmentor.jpaonweb.ejb.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jpaonweb.ejb.api.CategoryCRUDRepository;
import xyz.codingmentor.jpaonweb.ejb.entity.Category;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;

/**
 *
 * @author blazefury
 */
@Stateless
public class CategoryRepository implements CategoryCRUDRepository {
    
    @PersistenceContext(unitName = "hollywoodPU")
    private EntityManager entityManager;
    
    @Override
    public void persist(Category category) throws RepositoryException {
        entityManager.persist(category);
    }
    
    @Override
    public Category find(int id) throws RepositoryException {
        return entityManager.find(Category.class, id);
    }
    
    @Override
    public Category merge(Category category) throws RepositoryException {
        return entityManager.merge(category);
    }
    
    @Override
    public void remove(int id) throws RepositoryException {
        entityManager.remove(find(id));
    }
    
}
