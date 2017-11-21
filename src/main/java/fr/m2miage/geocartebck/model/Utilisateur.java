package fr.m2miage.geocartebck.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable
{

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String nom;

	@Column(nullable = false)
    private String email;

	@Column(nullable = false)
    private String motdepasse;

	@OneToMany(mappedBy = "utilisateur")
    private Set<CartesUtilisateur> lesCartesUtilisateur;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public Set<CartesUtilisateur> getLesCartesUtilisateur() {
        return lesCartesUtilisateur;
    }

    public void setLesCartesUtilisateur(Set<CartesUtilisateur> lesCartesUtilisateur) {
        this.lesCartesUtilisateur = lesCartesUtilisateur;
    }

    public Utilisateur()
    {

    }

    public Utilisateur(String nom, String email, String motdepasse) {
        this.nom = nom;
        this.email = email;
        this.motdepasse = motdepasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilisateur)) return false;

        Utilisateur that = (Utilisateur) o;

        if (getId() != that.getId()) return false;
        if (!getNom().equals(that.getNom())) return false;
        if (!getEmail().equals(that.getEmail())) return false;
        return getMotdepasse().equals(that.getMotdepasse());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getNom().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getMotdepasse().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", motdepasse='" + motdepasse + '\'' +
                '}';
    }

}