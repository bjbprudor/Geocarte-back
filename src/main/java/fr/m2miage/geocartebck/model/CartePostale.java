package fr.m2miage.geocartebck.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "cartePostale")
public class CartePostale implements Serializable
{

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
    private long codeEditeur;

	@ManyToOne(optional = false)
    private Editeur editeur;

	//peut etre supprimée ?
	@ManyToOne
    private Monument monument;

	// peut etre supprimée
	@ManyToOne
    private Commune commune;

	@OneToMany(mappedBy = "cartePostale")
    private Set<VarianteCarte> lesVariantes;

    public long getId() {
        return id;
    }

    public long getCodeEditeur() {
        return codeEditeur;
    }

    public void setCodeEditeur(long codeEditeur) {
        this.codeEditeur = codeEditeur;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public Monument getMonument() {
        return monument;
    }

    public void setMonument(Monument monument) {
        this.monument = monument;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public Set<VarianteCarte> getLesVariantes() {
        return lesVariantes;
    }

    public void setLesVariantes(Set<VarianteCarte> lesVariantes) {
        this.lesVariantes = lesVariantes;
    }

    public CartePostale()
    {

    }

    public CartePostale(long codeEditeur, Editeur editeur, Monument monument, Commune commune) {
        this.codeEditeur = codeEditeur;
        this.editeur = editeur;
        this.monument = monument;
        this.commune = commune;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartePostale)) return false;

        CartePostale that = (CartePostale) o;

        if (getId() != that.getId()) return false;
        if (getCodeEditeur() != that.getCodeEditeur()) return false;
        if (getEditeur() != null ? !getEditeur().equals(that.getEditeur()) : that.getEditeur() != null) return false;
        if (getMonument() != null ? !getMonument().equals(that.getMonument()) : that.getMonument() != null)
            return false;
        return getCommune() != null ? getCommune().equals(that.getCommune()) : that.getCommune() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (int) (getCodeEditeur() ^ (getCodeEditeur() >>> 32));
        result = 31 * result + (getEditeur() != null ? getEditeur().hashCode() : 0);
        result = 31 * result + (getMonument() != null ? getMonument().hashCode() : 0);
        result = 31 * result + (getCommune() != null ? getCommune().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CartePostale{" +
                "id=" + id +
                ", codeEditeur=" + codeEditeur +
                ", editeur=" + editeur +
                ", monument=" + monument +
                ", commune=" + commune +
                '}';
    }

}