package fr.m2miage.geocartebck.dao;

import fr.m2miage.geocartebck.model.CarteUtilisateurId;
import fr.m2miage.geocartebck.model.CarteUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteUtilisateurRepository extends JpaRepository<CarteUtilisateur, CarteUtilisateurId>
{
}