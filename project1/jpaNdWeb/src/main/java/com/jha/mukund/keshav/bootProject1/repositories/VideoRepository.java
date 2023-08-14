package com.jha.mukund.keshav.bootProject1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.jha.mukund.keshav.bootProject1.entities.VideoEntity;

//import jakarta.persistence.EntityManager;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
	
	List<VideoEntity> findByName(String name);

}
