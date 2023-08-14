package com.jha.mukund.keshav.bootProject1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jha.mukund.keshav.bootProject1.config.AppConfig;
import com.jha.mukund.keshav.bootProject1.config.SampleVideoConfig;
import com.jha.mukund.keshav.bootProject1.data.Video;
import com.jha.mukund.keshav.bootProject1.data.VideoSearch;
import com.jha.mukund.keshav.bootProject1.entities.VideoEntity;
import com.jha.mukund.keshav.bootProject1.services.VideoService;

@Controller
public class MVCHomePage {
	private final VideoService videoService;
	private final AppConfig appConfig;
//	private final SampleVideoConfig videoConfig;
	
//	@Autowired  // NOTE : Since there is only one constructor we do not need to Autowired here
	public MVCHomePage(VideoService vs, AppConfig appConfig, SampleVideoConfig videoConfig) {
		videoService = vs;
		this.appConfig = appConfig;
//		this.videoConfig = videoConfig;
	}
	
	@GetMapping("/")
	public String homePage(Model model) {
//	public String index() {
		 // NOTE : name index() nahi tha to error aaya , but only first time --- Next time se nahi aa raha
		model.addAttribute("videos", videoService.getVideos());   // This model should be present in the index.mustache
		return "index";
	}
	
	@PostMapping("/add-video")
	public String addVideo(@ModelAttribute Video newVideo){
		videoService.addVideo(newVideo);
		return "redirect:/";  // NOTE "redirect" is a Spring boot directive, and here it returns back to / . WHAT OTHER DIRECTIVES AVAILABLE ?? 
	}

	@PostMapping("/multi-field-search")
	public String multiFieldSearch(@ModelAttribute VideoSearch search, Model model) {
		List<VideoEntity> results = videoService.search(search);
		model.addAttribute("searchResults", results);   // This model should be present in the index.mustache
		return "index";
	}
}
