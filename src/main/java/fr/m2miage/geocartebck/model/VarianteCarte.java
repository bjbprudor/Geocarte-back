package fr.m2miage.geocartebck.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "varianteCarte")
public class VarianteCarte implements Serializable
{

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne(optional = false)
    private CartePostale cartePostale;

	@Column(nullable = false)
    private String legende;

	@Column(nullable = false)
    private String image;

	//variante
    //@ManyToOne
    //private Commune commune;

    //@ManyToOne
    //private Monument monument;

    @OneToMany(mappedBy = "varianteCarte")
    private Set<CartesUtilisateur> lesCartesUtilisateur;

    public int getId() {
        return id;
    }

    public CartePostale getCartePostale() {
        return cartePostale;
    }

    public void setCartePostale(CartePostale cartePostale) {
        this.cartePostale = cartePostale;
    }

    public String getLegende() {
        return legende;
    }

    public void setLegende(String legende) {
        this.legende = legende;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<CartesUtilisateur> getLesCartesUtilisateur() {
        return lesCartesUtilisateur;
    }

    public void setLesCartesUtilisateur(Set<CartesUtilisateur> lesCartesUtilisateur) {
        this.lesCartesUtilisateur = lesCartesUtilisateur;
    }

    public VarianteCarte()
    {

    }

    public VarianteCarte(CartePostale cartePostale, String legende, String image) {
        this.cartePostale = cartePostale;
        this.legende = legende;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VarianteCarte)) return false;

        VarianteCarte that = (VarianteCarte) o;

        if (getId() != that.getId()) return false;
        if (!getCartePostale().equals(that.getCartePostale())) return false;
        if (!getLegende().equals(that.getLegende())) return false;
        return getImage().equals(that.getImage());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getCartePostale().hashCode();
        result = 31 * result + getLegende().hashCode();
        result = 31 * result + getImage().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "VarianteCarte{" +
                "id=" + id +
                ", cartePostale=" + cartePostale +
                ", legende='" + legende + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

}