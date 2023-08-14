package com.jha.mukund.keshav.bootProject1.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jha.mukund.keshav.bootProject1.config.SampleVideoConfig;
import com.jha.mukund.keshav.bootProject1.data.Video;
import com.jha.mukund.keshav.bootProject1.data.VideoSearch;
import com.jha.mukund.keshav.bootProject1.entities.VideoEntity;
import com.jha.mukund.keshav.bootProject1.repositories.VideoRepository;

import lombok.Getter;

@Service
public class VideoService {
	private final VideoRepository repository;
	private final SampleVideoConfig videoConfig;

//	@Getter
	List<Video> sampleVideos;
//			List.of(
//			Arrays.asList( // NOTE Iss list ka bhi size change nahi kar sakte hain na . Check in JavaLearningProject
//			new Video("Sample First Video"),
//			new Video("Sample Second Video") // NOTE Server has to be restared for updates to model to be reflected
//			);

//	@Autowired
	public VideoService(VideoRepository repo, SampleVideoConfig config) {
		this.repository = repo;
		this.videoConfig = config;
		sampleVideos = videoConfig.sampleVideos();
		if (sampleVideos == null) {
			sampleVideos = List.of(
//					Arrays.asList( // NOTE Iss list ka bhi size change nahi kar sakte hain na . Check in JavaLearningProject
					new Video("Sample First Video"),
					new Video("Sample Second Video") // NOTE Server has to be restared for updates to model to be reflected
					);
		}
	}

	
	public List<Video> getVideos() {
		List<VideoEntity> dbVideos = repository.findAll();
		if(dbVideos == null || dbVideos.size() == 0) {
			return sampleVideos;
		} else {
			return dbVideos.stream().map(x -> new Video(x.getName())).collect(Collectors.toList());
		}
	}

	public void addVideo(Video video) {
		sampleVideos = new ArrayList<>(sampleVideos);
		sampleVideos.add(video);
	}

	public void addVideoToRepository (Video video) {
		sampleVideos = new ArrayList<>(sampleVideos);
		repository.save(new VideoEntity(video.name(), "Sample Description"));
		System.out.println(repository.findByName(video.name()));
	}

	public List<VideoEntity> search(VideoSearch videoSearch) {
		if(StringUtils.hasText(videoSearch.name()) && StringUtils.hasText(videoSearch.description()) ) {
			return repository.findByNameContainsOrDescriptionContainsAllIgnoreCase(videoSearch.name(), videoSearch.description());
		} else if ( StringUtils.hasText(videoSearch.name()) ) {
			return repository.findByNameContainsIgnoreCase(videoSearch.name());
		} else if ( StringUtils.hasText(videoSearch.description()) ) {
			return repository.findByDescriptionContainsIgnoreCase(videoSearch.description());
		} else {
			return List.of();
		}
	}
}
