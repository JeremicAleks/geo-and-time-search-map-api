package com.ftn.master.geoandtimesearchmapapi.service.serviceImpl;

import com.ftn.master.geoandtimesearchmapapi.domain.Role;
import com.ftn.master.geoandtimesearchmapapi.domain.User;
import com.ftn.master.geoandtimesearchmapapi.dto.RegistrationDTO;
import com.ftn.master.geoandtimesearchmapapi.dto.UserDTO;
import com.ftn.master.geoandtimesearchmapapi.enumeration.RoleType;
import com.ftn.master.geoandtimesearchmapapi.helper.UserMapperHelper;
import com.ftn.master.geoandtimesearchmapapi.repository.RoleRepository;
import com.ftn.master.geoandtimesearchmapapi.repository.UserRepository;
import com.ftn.master.geoandtimesearchmapapi.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO findOneUserById(Long id) {
        User user = userRepository.getOne(id);
        //TODO check if User is null, throw Exception
        return UserMapperHelper.userDTOFromEntity(user);
    }

    @Override
    public UserDTO findUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return UserMapperHelper.userDTOFromEntity(user);
    }

    @Override
    public UserDTO userRegistration(RegistrationDTO registrationDTO) {
        User user = new User();

        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setEmail(registrationDTO.getEmail());
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        Role role = roleRepository.findByName(RoleType.ADMIN);
        user.setRole(role);

        user = userRepository.save(user);

        return UserMapperHelper.userDTOFromEntity(user);
    }
}
