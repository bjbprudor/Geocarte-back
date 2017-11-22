package fr.m2miage.geocartebck.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CarteUtilisateurId implements Serializable
{

    @ManyToOne(optional = false)
    private VarianteCarte carte;

    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public VarianteCarte getCarte() {
        return carte;
    }

    public void setCarte(VarianteCarte carte) {
        this.carte = carte;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public CarteUtilisateurId() {
    }

    public CarteUtilisateurId(VarianteCarte carte, Utilisateur utilisateur) {
        this.carte = carte;
        this.utilisateur = utilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarteUtilisateurId)) return false;

        CarteUtilisateurId that = (CarteUtilisateurId) o;

        if (!getCarte().equals(that.getCarte())) return false;
        return getUtilisateur().equals(that.getUtilisateur());
    }

    @Override
    public int hashCode() {
        int result = getCarte().hashCode();
        result = 31 * result + getUtilisateur().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CarteUtilisateurId{" +
                "carte=" + carte +
                ", utilisateur=" + utilisateur +
                '}';
    }

}