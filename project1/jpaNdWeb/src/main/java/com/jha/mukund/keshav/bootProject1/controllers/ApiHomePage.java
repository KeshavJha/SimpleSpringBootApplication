package com.jha.mukund.keshav.bootProject1.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jha.mukund.keshav.bootProject1.data.Video;
import com.jha.mukund.keshav.bootProject1.services.VideoService;

@RestController
public class ApiHomePage {
	
	private final VideoService videoService;
	
	public ApiHomePage(VideoService vs) {
		videoService = vs;
	}
	
	@GetMapping("/api/videos")
	public List<Video> getVideos() {
		return videoService.getVideos();
	}
	
	@PostMapping("/api/videos")
	public void addVideo(@RequestBody Video video) {
		videoService.addVideo(video);
//		return videoService.getVideos();
	}

}
