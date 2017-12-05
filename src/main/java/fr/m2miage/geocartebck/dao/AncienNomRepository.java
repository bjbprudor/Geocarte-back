package fr.m2miage.geocartebck.dao;

import fr.m2miage.geocartebck.model.AncienNom;
import fr.m2miage.geocartebck.model.AncienNomId;
import fr.m2miage.geocartebck.model.CartePostale;
import fr.m2miage.geocartebck.model.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AncienNomRepository extends JpaRepository<AncienNom, AncienNomId>
{
    @Query("select max(id) as id from AncienNom an where an.id.commune like %?1")
    int findLastId(Commune commune);
}