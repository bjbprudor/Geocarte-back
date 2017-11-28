package fr.m2miage.geocartebck.model;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "typeMonument")
public class TypeMonument implements Serializable
{

	@Id
    @GeneratedValue
	private int numero;

	@Column(nullable = false)
    private String libelle;

    public int getNumero() {
        return numero;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public TypeMonument() {
    }

    public TypeMonument(String libelle) {
        this.libelle = libelle;
    }
}