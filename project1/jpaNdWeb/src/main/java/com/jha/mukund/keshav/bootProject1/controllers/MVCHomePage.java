package com.jha.mukund.keshav.bootProject1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jha.mukund.keshav.bootProject1.data.Video;
import com.jha.mukund.keshav.bootProject1.services.VideoService;

@Controller
public class MVCHomePage {
	private final VideoService videoService;
	
//	@Autowired  // NOTE : Since there is only one constructor we do not need to Autowire here
	public MVCHomePage(VideoService vs) {
		videoService = vs;
	}
	
	@GetMapping("/")
	public String homePage(Model model) {
//	public String index() {
		 // NOTE : name index() nahi tha to error aaya , but only first time --- Next time se nahi aa raha
		model.addAttribute("videos", videoService.getVideos());
		return "index";
	}
	
	@PostMapping("/add-video")
	public String addVideo(@ModelAttribute Video newVideo){
		videoService.addVideo(newVideo);
		return "redirect:/";  // NOTE "redirect" is a Spring boot directive, and here it returns back to / . WHAT OTHER DIRECTIVES AVAILABLE ?? 
	}
}
