package fr.m2miage.geocartebck.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class VarianteCarteId implements Serializable
{

    @Column(name = "id")
    @GeneratedValue
    private int id;

    @ManyToOne(optional = false)
    private CartePostale cartePostale;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CartePostale getCartePostale() {
        return cartePostale;
    }

    public void setCartePostale(CartePostale cartePostale) {
        this.cartePostale = cartePostale;
    }

    public VarianteCarteId() {
    }

    public VarianteCarteId(CartePostale cartePostale) {
        this.cartePostale = cartePostale;
    }
}