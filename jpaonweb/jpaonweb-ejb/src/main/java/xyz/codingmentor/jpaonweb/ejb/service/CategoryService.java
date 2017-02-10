package xyz.codingmentor.jpaonweb.ejb.service;

import javax.inject.Inject;
import xyz.codingmentor.jpaonweb.ejb.entity.Category;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;
import xyz.codingmentor.jpaonweb.ejb.repository.CategoryRepository;

/**
 *
 * @author blazefury
 */
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Inject
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryService() {
        //empty on purpose
    }

    public Category getCategoryById(int id) throws RepositoryException {
        return categoryRepository.find(id);
    }

    public void addCategory(Category category) throws RepositoryException {
        categoryRepository.persist(category);
    }

    public Category editCategory(Category category) throws RepositoryException {
        return categoryRepository.merge(category);
    }

    public void removeCategory(int id) throws RepositoryException {
        categoryRepository.remove(id);
    }

}
