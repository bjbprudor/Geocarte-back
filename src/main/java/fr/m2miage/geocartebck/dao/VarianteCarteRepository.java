package fr.m2miage.geocartebck.dao;

import fr.m2miage.geocartebck.model.CartePostale;
import fr.m2miage.geocartebck.model.VarianteCarte;
import fr.m2miage.geocartebck.model.VarianteCarteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VarianteCarteRepository extends JpaRepository<VarianteCarte, VarianteCarteId>
{
    @Query("select max(id) as id from VarianteCarte v where v.id.cartePostale like %?1")
    int findLastId(CartePostale cartePostale);
}