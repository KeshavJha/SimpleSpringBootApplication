package com.jha.mukund.keshav.bootProject1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class VideoEntity {
	@Getter
	private @Id @GeneratedValue Long id;
	@Getter
	private String name;
	@Getter
	private String description;
	
	public VideoEntity(String name , String description) {
		this.description = description;
		this.name = name;
	}
	
}
