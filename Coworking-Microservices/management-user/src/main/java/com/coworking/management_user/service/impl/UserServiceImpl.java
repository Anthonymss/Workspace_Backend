package com.coworking.management_user.service.impl;

import com.coworking.management_user.exception.EmailNotFoundException;
import com.coworking.management_user.persistence.entity.User;
import com.coworking.management_user.persistence.repository.UserRepository;
import com.coworking.management_user.presentation.dto.UserDto;
import com.coworking.management_user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public UserDto getUserByEmail(String email) {
        Optional<User> userOpt=userRepository.findByEmail(email);
        if (userOpt.isEmpty()){
            throw new EmailNotFoundException("Not found user with email " + email);
        }
        User user=userOpt.get();
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
