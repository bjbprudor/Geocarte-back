package fr.m2miage.geocartebck.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ancienNom")
public class AncienNom implements Serializable
{

	@Id
    @GeneratedValue
	private long id;

    @ManyToOne(optional = false)
    private Commune commune;

    @Column
    private String article;

    @Column(nullable = false)
    private String nom;

    public long getId()
    {
        return id;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
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

    public AncienNom()
    {

    }

    public AncienNom(Commune commune, String article, String nom)
    {
        this.commune = commune;
        this.article = article;
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AncienNom)) return false;

        AncienNom ancienNom = (AncienNom) o;

        if (getId() != ancienNom.getId()) return false;
        if (!getCommune().equals(ancienNom.getCommune())) return false;
        if (getArticle() != null ? !getArticle().equals(ancienNom.getArticle()) : ancienNom.getArticle() != null)
            return false;
        return getNom().equals(ancienNom.getNom());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getCommune().hashCode();
        result = 31 * result + (getArticle() != null ? getArticle().hashCode() : 0);
        result = 31 * result + getNom().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AncienNom{" +
                "id=" + id +
                ", commune=" + commune +
                ", article='" + article + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }

}