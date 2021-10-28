package com.castedodev.mymoneycheckback.service;

import java.util.ArrayList;
import java.util.Optional;

import com.castedodev.mymoneycheckback.user.services.FindUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	private final FindUser findUser;

	public JwtUserDetailsService(FindUser findUser) {
		this.findUser = findUser;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> opt = findUser.find(username);
		if ("techgeeknext".equals(username)) {
			return new User("techgeeknext", "$2a$10$ixlPY3AAd4ty1l6E2IsQ9OFZi2ba9ZQE0bP7RFcGIWNhyFrrT3YUi",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}