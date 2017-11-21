package fr.m2miage.geocartebck.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "departement")
public class Departement implements Serializable
{

	@Id
	private int numero;

	@Column(nullable = false)
    private String nom;

    @OneToMany(mappedBy = "departement")
    private Set<Commune> lesCommunes;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Commune> getLesCommunes() {
        return lesCommunes;
    }

    public void setLesCommunes(Set<Commune> lesCommunes) {
        this.lesCommunes = lesCommunes;
    }

    public Departement()
    {

    }

    public Departement(int numero, String nom) {
        this.numero = numero;
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departement)) return false;

        Departement that = (Departement) o;

        if (getNumero() != that.getNumero()) return false;
        return getNom().equals(that.getNom());
    }

    @Override
    public int hashCode() {
        int result = getNumero();
        result = 31 * result + getNom().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                '}';
    }

}