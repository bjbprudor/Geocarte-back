package fr.m2miage.geocartebck.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.m2miage.geocartebck.model.ComposedEntity;
import fr.m2miage.geocartebck.model.ComposedId;

public interface ComposedEntityRepository extends JpaRepository<ComposedEntity, ComposedId>
{
}