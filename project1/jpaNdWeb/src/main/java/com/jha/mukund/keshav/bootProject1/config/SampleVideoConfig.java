package com.jha.mukund.keshav.bootProject1.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.jha.mukund.keshav.bootProject1.data.Video;

@ConfigurationProperties("sample-video.config")
public record SampleVideoConfig(List<Video> sampleVideos) {

}
