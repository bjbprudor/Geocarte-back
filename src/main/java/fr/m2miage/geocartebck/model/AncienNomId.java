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

    public void setId(int id) {
        this.id = id;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public AncienNomId()
    {

    }

    public AncienNomId(Commune commune)
    {
        this.commune = commune;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AncienNomId)) return false;

        AncienNomId that = (AncienNomId) o;

        if (getId() != that.getId()) return false;
        return getCommune().equals(that.getCommune());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getCommune().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AncienNomId{" +
                "id=" + id +
                ", commune=" + commune +
                '}';
    }

}