package fr.m2miage.geocartebck.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "editeur")
public class Editeur implements Serializable
{

	@Id
    @GeneratedValue
	private long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String nom;

	@ManyToOne
    private Commune commune;

	@OneToMany(mappedBy = "editeur")
    private Set<CartePostale> lesCartesPostales;

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public Set<CartePostale> getLesCartesPostales() {
        return lesCartesPostales;
    }

    public void setLesCartesPostales(Set<CartePostale> lesCartesPostales) {
        this.lesCartesPostales = lesCartesPostales;
    }

    public Editeur()
    {

    }

    public Editeur(String code, String nom, Commune commune) {
        this.code = code;
        this.nom = nom;
        this.commune = commune;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Editeur)) return false;

        Editeur editeur = (Editeur) o;

        if (getId() != editeur.getId()) return false;
        if (!getCode().equals(editeur.getCode())) return false;
        if (!getNom().equals(editeur.getNom())) return false;
        return getCommune() != null ? getCommune().equals(editeur.getCommune()) : editeur.getCommune() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getCode().hashCode();
        result = 31 * result + getNom().hashCode();
        result = 31 * result + (getCommune() != null ? getCommune().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Editeur{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", commune=" + commune +
                '}';
    }

}