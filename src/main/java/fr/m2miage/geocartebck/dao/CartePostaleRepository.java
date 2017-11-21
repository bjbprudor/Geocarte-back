package fr.m2miage.geocartebck.dao;

import fr.m2miage.geocartebck.model.CartePostale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartePostaleRepository extends JpaRepository<CartePostale, Integer>
{
}