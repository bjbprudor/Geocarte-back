package fr.m2miage.geocartebck.dao;

import fr.m2miage.geocartebck.model.Commune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommuneRepository extends JpaRepository<Commune, String>
{
}