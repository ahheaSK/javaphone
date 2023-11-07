package com.makara.java.kit.javahome.service.impl;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.makara.java.kit.javahome.config.security.AuthUser;
import com.makara.java.kit.javahome.config.security.UserService;
import com.makara.java.kit.javahome.entity.User;
import com.makara.java.kit.javahome.exception.ApiException;
import com.makara.java.kit.javahome.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Primary
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserRepository userRepository;

	@Override
	public Optional<AuthUser> findUserByUsername(String username) {
		User user = userRepository.findByUsername(username)
			.orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "User not found "));
		
		AuthUser authUser = AuthUser.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.authorities(user.getRole().getAuthorities())
				.accountNonExpired(user.isAccountNonExpired())
				.accountNonLocked(user.isAccountNonLocked())
				.credentialsNonExpired(user.isCredentialsNonExpired())
				.enabled(user.isEnabled())
				.build();
		
		return Optional.ofNullable(authUser);
	}

}