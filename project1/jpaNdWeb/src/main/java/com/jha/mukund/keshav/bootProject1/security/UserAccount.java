package com.jha.mukund.keshav.bootProject1.security;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAccount {
	String username;
	String password;
	List<Authority> grantedAccesses;
}
