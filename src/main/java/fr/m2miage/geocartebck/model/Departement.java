package fr.m2miage.geocartebck.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "departement")
public class Departement implements Serializable
{

	@Id
	private int numero;

	@Column(nullable = false)
    private String nom;

    @OneToMany(mappedBy = "departement")
    private List<Commune> communes;

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

    public List<Commune> getCommunes() {
        return communes;
    }

    public void setCommunes(List<Commune> communes) {
        this.communes = communes;
    }

    public Departement() {
    }

    public Departement(int numero, String nom) {
        this.numero = numero;
        this.nom = nom;
    }
}