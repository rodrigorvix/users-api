package com.letscode.usersapi.service;

import com.letscode.usersapi.dto.UserDTO;
import com.letscode.usersapi.domain.UserEntity;
import com.letscode.usersapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.SecureRandom;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    BCryptPasswordEncoder bCryptPasswordEncoder =
            new BCryptPasswordEncoder(10, new SecureRandom());

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getUsers() {
        List<UserEntity> users = this.userRepository.findAll();

        return users;
    }

    public UserDTO getUserById(Long id) {
       Optional<UserEntity> userExists = this.userRepository.findById(id);

       if(userExists.isEmpty()) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
       }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userExists.get().getId());
        userDTO.setUsername(userExists.get().getUsername());
        userDTO.setName(userExists.get().getName());
        userDTO.setProfile(userExists.get().getProfile());
        userDTO.setBirthDate(userExists.get().getBirthDate());
        return userDTO;
    }

    public UserEntity createUser(UserEntity user) {

        List<UserEntity> usernameSearch = this.userRepository.findAll()
                .stream()
                .filter(userExists -> userExists.getUsername().equals(user.getUsername()))
                .collect(Collectors.toList());

        if(usernameSearch.size() > 0) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Usuário já existe.");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setCreatedAt(ZonedDateTime.now());
        user.setUpdatedAt(ZonedDateTime.now());

        return  this.userRepository.save(user);
    }

    public void deleteUserByID(Long id) {
        this.userRepository.findById(id)
                .map( userExists -> {
                    this.userRepository.delete(userExists);
                    return userExists;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    public void updateUserById(UserEntity user,Long id) {
        this.userRepository
                .findById(id)
                .map(userExists -> {
                    user.setId(userExists.getId());
                    user.setCreatedAt(userExists.getCreatedAt());
                    user.setUpdatedAt(ZonedDateTime.now());
                    this.userRepository.save(user);
                    return userExists;
                }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

}
