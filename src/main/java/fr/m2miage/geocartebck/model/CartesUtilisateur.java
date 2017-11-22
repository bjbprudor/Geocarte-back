package fr.m2miage.geocartebck.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cartesUtilisateur")
public class CartesUtilisateur implements Serializable
{

    @EmbeddedId
    private CarteUtilisateurId id;

    @Column(nullable = false)
    private int nombreExemplaires;

    public CarteUtilisateurId getId() {
        return id;
    }

    public void setId(CarteUtilisateurId id) {
        this.id = id;
    }

    public int getNombreExemplaires() {
        return nombreExemplaires;
    }

    public void setNombreExemplaires(int nombreExemplaires) {
        this.nombreExemplaires = nombreExemplaires;
    }

    public CartesUtilisateur() {
    }

    public CartesUtilisateur(CarteUtilisateurId id, int nombreExemplaires) {
        this.id = id;
        this.nombreExemplaires = nombreExemplaires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartesUtilisateur)) return false;

        CartesUtilisateur that = (CartesUtilisateur) o;

        if (getNombreExemplaires() != that.getNombreExemplaires()) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getNombreExemplaires();
        return result;
    }

    @Override
    public String toString() {
        return "CartesUtilisateur{" +
                "id=" + id +
                ", nombreExemplaires=" + nombreExemplaires +
                '}';
    }

}