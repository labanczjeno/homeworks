package xyz.codingmentor.jpa.technical.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author blazefury
 */
@Entity
@Table(name = "Technicians")
public class Technican implements Serializable {

    @Id @GeneratedValue
    private int id;
    private String name;
    @ManyToMany
    @JoinTable(name = "jnd_techs_products",
            joinColumns = @JoinColumn(name = "tech_fk"),
            inverseJoinColumns = @JoinColumn(name = "product_fk"))
    private List<Product> assembles;

    public Technican() {
        //constructor without parameters
    }

    public List<Product> getAssembles() {
        return assembles;
    }

    public void setAssembles(List<Product> assembles) {
        this.assembles = assembles;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
