package fr.m2miage.geocartebck.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "varianteCarte")
public class VarianteCarte implements Serializable
{

    @EmbeddedId
    private VarianteCarteId id;

	@Column(nullable = false)
    private String legende;

	@Column(nullable = false)
    private String image;

    @OneToMany(mappedBy = "id.carte")
    private Set<CartesUtilisateur> lesCartesUtilisateur;

    public VarianteCarteId getId() {
        return id;
    }

    public void setId(VarianteCarteId id) {
        this.id = id;
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

    public VarianteCarte(VarianteCarteId id, String legende, String image) {
        this.id = id;
        this.legende = legende;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VarianteCarte)) return false;

        VarianteCarte that = (VarianteCarte) o;

        if (!getId().equals(that.getId())) return false;
        if (!getLegende().equals(that.getLegende())) return false;
        return getImage().equals(that.getImage());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getLegende().hashCode();
        result = 31 * result + getImage().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "VarianteCarte{" +
                "id=" + id +
                ", legende='" + legende + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}