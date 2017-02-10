package xyz.codingmentor.jpaonweb.ejb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import xyz.codingmentor.jpaonweb.ejb.type.CategoryType;

/**
 *
 * @author blazefury
 */
@Entity
public class Category implements Serializable {

    @Id @GeneratedValue
    private int categoryId;
    private CategoryType categoryType;
    @OneToMany(mappedBy = "category")
    private List<Film> films;

    public Category() {
        //empty on purpose
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

}
