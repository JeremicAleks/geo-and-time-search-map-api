package com.ftn.master.geoandtimesearchmapapi.service.serviceImpl;

import com.ftn.master.geoandtimesearchmapapi.domain.Role;
import com.ftn.master.geoandtimesearchmapapi.domain.User;
import com.ftn.master.geoandtimesearchmapapi.dto.*;
import com.ftn.master.geoandtimesearchmapapi.enumeration.RoleType;
import com.ftn.master.geoandtimesearchmapapi.helper.UserMapperHelper;
import com.ftn.master.geoandtimesearchmapapi.repository.RoleRepository;
import com.ftn.master.geoandtimesearchmapapi.repository.UserRepository;
import com.ftn.master.geoandtimesearchmapapi.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
        user.setEnabled(false);
        Role role = roleRepository.findByName(RoleType.ADMIN);
        user.setRole(role);

        user = userRepository.save(user);

        return UserMapperHelper.userDTOFromEntity(user);
    }

    @Override
    public UserListDTO getAllEnabledUsers() {
        List<User> users = userRepository.getAllEnabledUsers();
        UserListDTO userListDTO = new UserListDTO();
        for(User user : users){
            userListDTO.getUsers().add(UserMapperHelper.userDTOFromEntity(user));
        }
        return userListDTO;
    }

    @Override
    public UserListDTO getAllDisabledUsers() {
        List<User> users = userRepository.getAllDisabledUsers();
        UserListDTO userListDTO = new UserListDTO();
        for(User user : users){
            userListDTO.getUsers().add(UserMapperHelper.userDTOFromEntity(user));
        }
        return userListDTO;
    }

    @Override
    public UserDTO enableUser(UserDTO userDTO) {
        User user = userRepository.getOne(userDTO.getId());
        user.setEnabled(true);
        user = userRepository.save(user);
        return UserMapperHelper.userDTOFromEntity(user);
    }

    @Override
    public UserDTO disableUser(UserDTO userDTO) {
        User user = userRepository.getOne(userDTO.getId());
        user.setEnabled(false);
        user = userRepository.save(user);
        return UserMapperHelper.userDTOFromEntity(user);
    }

    @Override
    public PageableResponseUserDTO pageableGetUsers(PageableRequestDTO pageableRequestDTO) {
        Page<User> userPage = userRepository.findByEnabled(pageableRequestDTO.isFlagFilter(), PageRequest.of(pageableRequestDTO.getPage(),pageableRequestDTO.getSize()));
        PageableResponseUserDTO pageableResponseUserDTO = new PageableResponseUserDTO();
        pageableResponseUserDTO.setTotalPages(userPage.getTotalPages());
        pageableResponseUserDTO.setTotalElements(userPage.getTotalElements());
        for (User user: userPage.getContent()){
            pageableResponseUserDTO.getUserListDTO().getUsers().add(UserMapperHelper.userDTOFromEntity(user));
        }
        return pageableResponseUserDTO;
    }
}
