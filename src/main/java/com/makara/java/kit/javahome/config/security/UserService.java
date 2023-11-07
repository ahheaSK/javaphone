package com.makara.java.kit.javahome.config.security;

import java.util.Optional;

public interface UserService {
	Optional<AuthUser> findUserByUsername(String username);
}
