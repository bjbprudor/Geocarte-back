package fr.m2miage.geocartebck.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "monument")
public class Monument implements Serializable
{

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String nom;

	@Column(nullable = false)
	private int anneeConstruction;

	@Column
	private String divers;

	@Column(nullable = false)
    private float longitude;

	@Column(nullable = false)
    private float latitude;

	@ManyToOne
    private Commune commune;

	@OneToMany(mappedBy = "monument")
    private Set<CartePostale> lesCartesPostales;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAnneeConstruction() {
        return anneeConstruction;
    }

    public void setAnneeConstruction(int anneeConstruction) {
        this.anneeConstruction = anneeConstruction;
    }

    public String getDivers() {
        return divers;
    }

    public void setDivers(String divers) {
        this.divers = divers;
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

    public Monument()
    {

    }

    public Monument(String nom, int anneeConstruction, String divers, float longitude, float latitude, Commune commune) {
        this.nom = nom;
        this.anneeConstruction = anneeConstruction;
        this.divers = divers;
        this.longitude = longitude;
        this.latitude = latitude;
        this.commune = commune;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monument)) return false;

        Monument monument = (Monument) o;

        if (getId() != monument.getId()) return false;
        if (getAnneeConstruction() != monument.getAnneeConstruction()) return false;
        if (Float.compare(monument.getLongitude(), getLongitude()) != 0) return false;
        if (Float.compare(monument.getLatitude(), getLatitude()) != 0) return false;
        if (!getNom().equals(monument.getNom())) return false;
        if (getDivers() != null ? !getDivers().equals(monument.getDivers()) : monument.getDivers() != null)
            return false;
        return getCommune() != null ? getCommune().equals(monument.getCommune()) : monument.getCommune() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getNom().hashCode();
        result = 31 * result + getAnneeConstruction();
        result = 31 * result + (getDivers() != null ? getDivers().hashCode() : 0);
        result = 31 * result + (getLongitude() != +0.0f ? Float.floatToIntBits(getLongitude()) : 0);
        result = 31 * result + (getLatitude() != +0.0f ? Float.floatToIntBits(getLatitude()) : 0);
        result = 31 * result + (getCommune() != null ? getCommune().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Monument{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", anneeConstruction=" + anneeConstruction +
                ", divers='" + divers + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", commune=" + commune +
                '}';
    }

}