package xyz.codingmentor.jpa.technical.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import xyz.codingmentor.jpa.technical.api.ProductEnum;

/**
 *
 * @author blazefury
 */
@Entity
@Table(name = "Products")
public class Product implements Serializable {

    @Id
    private int productID;
    @Enumerated(EnumType.STRING)
    private ProductEnum productName;
    @ManyToMany(mappedBy = "assembles")
    private List<Technican> assembledByTech;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_fk")
    private List<Part> parts;

    public Product() {
        //constructor without parameters
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public ProductEnum getProductName() {
        return productName;
    }

    public void setProductName(ProductEnum productName) {
        this.productName = productName;
    }

    public List<Technican> getAssembledByTech() {
        return assembledByTech;
    }

    public void setAssembledByTech(List<Technican> assembledByTech) {
        this.assembledByTech = assembledByTech;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

}
