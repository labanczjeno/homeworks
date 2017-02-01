package xyz.codingmentor.jpa.technical.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import xyz.codingmentor.jpa.technical.api.ProductEnum;

/**
 *
 * @author blazefury
 */
@Entity
@Table(name = "Parts")
public class Part implements Serializable {

    @Id @GeneratedValue
    private int partID;
    @Enumerated(EnumType.STRING)
    private ProductEnum partName;
    private int unitPrice;
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    public Part() {
        //constructor without parameters
    }

    public ProductEnum getPartName() {
        return partName;
    }

    public void setPartName(ProductEnum partName) {
        this.partName = partName;
    }

    public int getPartID() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

}
