package fr.m2miage.geocartebck.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "commune")
public class Commune implements Serializable
{

	@Id
	private int insee;

	@Column
	private String article;

	@Column(nullable = false)
    private String nom;

	@Column(nullable = false)
    private float longitude;

	@Column(nullable = false)
    private float latitude;

	@ManyToOne(optional = false)
    private Departement departement;

    @OneToMany(mappedBy = "id.commune")
    private Set<AncienNom> lesAnciensNoms;

	@ManyToOne
    private Commune ancienneCommune;

    @OneToMany(mappedBy = "ancienneCommune")
    private Set<Commune> lesAnciennesCommunes;

    @OneToMany(mappedBy = "commune")
    private Set<Editeur> lesEditeurs;

    @OneToMany(mappedBy = "commune")
    private Set<Monument> lesMonuments;

    @OneToMany(mappedBy = "commune")
    private Set<CartePostale> lesCartePostales;

    public int getInsee() {
        return insee;
    }

    public void setInsee(int insee) {
        this.insee = insee;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Set<AncienNom> getLesAnciensNoms() {
        return lesAnciensNoms;
    }

    public void setLesAnciensNoms(Set<AncienNom> lesAnciensNoms) {
        this.lesAnciensNoms = lesAnciensNoms;
    }

    public Commune getAncienneCommune() {
        return ancienneCommune;
    }

    public void setAncienneCommune(Commune ancienneCommune) {
        this.ancienneCommune = ancienneCommune;
    }

    public Set<Commune> getLesAnciennesCommunes() {
        return lesAnciennesCommunes;
    }

    public void setLesAnciennesCommunes(Set<Commune> lesAnciennesCommunes) {
        this.lesAnciennesCommunes = lesAnciennesCommunes;
    }

    public Set<Editeur> getLesEditeurs() {
        return lesEditeurs;
    }

    public void setLesEditeurs(Set<Editeur> lesEditeurs) {
        this.lesEditeurs = lesEditeurs;
    }

    public Set<Monument> getLesMonuments() {
        return lesMonuments;
    }

    public void setLesMonuments(Set<Monument> lesMonuments) {
        this.lesMonuments = lesMonuments;
    }

    public Set<CartePostale> getLesCartePostales() {
        return lesCartePostales;
    }

    public void setLesCartePostales(Set<CartePostale> lesCartePostales) {
        this.lesCartePostales = lesCartePostales;
    }

    public Commune()
    {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commune)) return false;

        Commune commune = (Commune) o;

        if (getInsee() != commune.getInsee()) return false;
        if (Float.compare(commune.getLongitude(), getLongitude()) != 0) return false;
        if (Float.compare(commune.getLatitude(), getLatitude()) != 0) return false;
        if (getArticle() != null ? !getArticle().equals(commune.getArticle()) : commune.getArticle() != null)
            return false;
        if (!getNom().equals(commune.getNom())) return false;
        if (!getDepartement().equals(commune.getDepartement())) return false;
        return getAncienneCommune() != null ? getAncienneCommune().equals(commune.getAncienneCommune()) : commune.getAncienneCommune() == null;
    }

    @Override
    public int hashCode() {
        int result = getInsee();
        result = 31 * result + (getArticle() != null ? getArticle().hashCode() : 0);
        result = 31 * result + getNom().hashCode();
        result = 31 * result + (getLongitude() != +0.0f ? Float.floatToIntBits(getLongitude()) : 0);
        result = 31 * result + (getLatitude() != +0.0f ? Float.floatToIntBits(getLatitude()) : 0);
        result = 31 * result + getDepartement().hashCode();
        result = 31 * result + (getAncienneCommune() != null ? getAncienneCommune().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Commune{" +
                "insee=" + insee +
                ", article='" + article + '\'' +
                ", nom='" + nom + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

}