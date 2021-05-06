package com.ftn.master.geoandtimesearchmapapi.service.serviceImpl;

import com.ftn.master.geoandtimesearchmapapi.domain.User;
import com.ftn.master.geoandtimesearchmapapi.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {


	private final UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		} else {
			Set<GrantedAuthority> grantedAuthority = new HashSet<GrantedAuthority>();
			grantedAuthority.add(new SimpleGrantedAuthority(user.getRole().getName()));

			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					grantedAuthority);
		}
	}

}
