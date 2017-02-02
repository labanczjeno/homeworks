package xyz.codingmentor.jpa.technical.entity;

import xyz.codingmentor.jpa.technical.embeddable.AssembleID;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author blazefury
 */
@Entity
@Table(name = "Assembles")
public class Assemble implements Serializable {

    @EmbeddedId
    private AssembleID id;
    private int quantity;
    @Temporal(TemporalType.DATE)
    private Date dateOfAssemble;

    public Assemble() {
        //constructor without parameters
    }

    public AssembleID getId() {
        return id;
    }

    public void setId(AssembleID id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateOfAssemble() {
        return dateOfAssemble;
    }

    public void setDateOfAssemble(Date dateOfAssemble) {
        this.dateOfAssemble = dateOfAssemble;
    }

}
