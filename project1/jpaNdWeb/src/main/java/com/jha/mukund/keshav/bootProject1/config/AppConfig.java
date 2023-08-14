package com.jha.mukund.keshav.bootProject1.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.jha.mukund.keshav.bootProject1.security.UserAccount;

@ConfigurationProperties("app.config")
public record AppConfig(String header, String intro, List<UserAccount> users) {
}
