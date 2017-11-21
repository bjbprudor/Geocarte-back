package fr.m2miage.geocartebck.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cartesUtilisateur")
public class CartesUtilisateur implements Serializable
{

	@Id
	private int id;

    @ManyToOne(optional = false)
    private VarianteCarte varianteCarte;

    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    @Column(nullable = false)
    private int nombreExemplaires;

    public int getId() {
        return id;
    }

    public VarianteCarte getVarianteCarte() {
        return varianteCarte;
    }

    public void setVarianteCarte(VarianteCarte varianteCarte) {
        this.varianteCarte = varianteCarte;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getNombreExemplaires() {
        return nombreExemplaires;
    }

    public void setNombreExemplaires(int nombreExemplaires) {
        this.nombreExemplaires = nombreExemplaires;
    }

    public CartesUtilisateur()
    {

    }

    public CartesUtilisateur(int id, VarianteCarte varianteCarte, Utilisateur utilisateur, int nombreExemplaires) {
        this.id = id;
        this.varianteCarte = varianteCarte;
        this.utilisateur = utilisateur;
        this.nombreExemplaires = nombreExemplaires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartesUtilisateur)) return false;

        CartesUtilisateur that = (CartesUtilisateur) o;

        if (getId() != that.getId()) return false;
        if (getNombreExemplaires() != that.getNombreExemplaires()) return false;
        if (!getVarianteCarte().equals(that.getVarianteCarte())) return false;
        return getUtilisateur().equals(that.getUtilisateur());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getVarianteCarte().hashCode();
        result = 31 * result + getUtilisateur().hashCode();
        result = 31 * result + getNombreExemplaires();
        return result;
    }

    @Override
    public String toString() {
        return "CartesUtilisateur{" +
                "id=" + id +
                ", varianteCarte=" + varianteCarte +
                ", utilisateur=" + utilisateur +
                ", nombreExemplaires=" + nombreExemplaires +
                '}';
    }

}