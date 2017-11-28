package fr.m2miage.geocartebck.dao;

import fr.m2miage.geocartebck.model.AncienNom;
import fr.m2miage.geocartebck.model.AncienNomId;
import fr.m2miage.geocartebck.model.Commune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AncienNomRepository extends JpaRepository<AncienNom, AncienNomId>
{

    public int GetNextId(Commune c)
    {
        //return this.findAll("id");
        return 0;
    }

}