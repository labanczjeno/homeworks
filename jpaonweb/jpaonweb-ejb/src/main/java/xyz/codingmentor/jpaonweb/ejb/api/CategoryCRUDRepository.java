package xyz.codingmentor.jpaonweb.ejb.api;

import xyz.codingmentor.jpaonweb.ejb.entity.Category;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;

/**
 *
 * @author blazefury
 */
public interface CategoryCRUDRepository {

    void persist(Category category) throws RepositoryException;

    Category find(int id) throws RepositoryException;

    Category merge(Category category) throws RepositoryException;

    void remove(int id) throws RepositoryException;
}
