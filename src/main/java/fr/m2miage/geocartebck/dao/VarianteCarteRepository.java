package fr.m2miage.geocartebck.dao;

import fr.m2miage.geocartebck.model.VarianteCarte;
import fr.m2miage.geocartebck.model.VarianteCarteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VarianteCarteRepository extends JpaRepository<VarianteCarte, VarianteCarteId>
{
}