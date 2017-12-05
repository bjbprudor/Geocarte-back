package fr.m2miage.geocartebck.dao;

import fr.m2miage.geocartebck.model.Commune;
import fr.m2miage.geocartebck.model.TypeMonument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeMonumentRepository extends JpaRepository<TypeMonument, Integer>
{
}