package com.jha.mukund.keshav.bootProject1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.jha.mukund.keshav.bootProject1.entities.VideoEntity;

//import jakarta.persistence.EntityManager;


/**
 * And and Or - can be used to combine multiple property expressions.
 * Between, LessThan, and GreaterThan - can also be used
 * IsStartingWith, StartingWith, StartsWith, IsEndingWith, EndingWith, EndsWith, IsContaining, Containing, Like, IsNotContaining, NotContaining, and NotContains -- can be applied
 * Apply IgnoreCase against a single field, or if you want to apply it to all properties, use AllIgnoreCase at the end
 * Apply OrderBy with Asc or Desc against a field
 */
public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
	
	List<VideoEntity> findByName(String name);
//	List<VideoEntity> findIsStartingWithName(String name);
//	List<VideoEntity> findIsEndingWithNameOrderByName(String name);

	List<VideoEntity> findByNameContainsIgnoreCase(String name);
	List<VideoEntity> findByDescriptionContainsIgnoreCase(String description);
	List<VideoEntity> findByNameContainsOrDescriptionContainsAllIgnoreCase(String name, String description);

}
