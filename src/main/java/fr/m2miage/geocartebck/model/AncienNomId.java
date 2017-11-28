package fr.m2miage.geocartebck.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class AncienNomId implements Serializable
{

    @Column(name = "id")
    @GeneratedValue
    private int id;

    @ManyToOne(optional = false)
    private Commune commune;

    public int getId() {
        return id;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public AncienNomId() {
    }

    public AncienNomId(Commune commune) {
        this.commune = commune;
    }

}