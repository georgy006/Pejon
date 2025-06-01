package com.example.pejon.service.Impl;

import com.example.pejon.model.Role;
import com.example.pejon.model.User;
import com.example.pejon.model.dto.auth.RegisterRequest;
import com.example.pejon.model.dto.user_dto.UserCreateDto;
import com.example.pejon.model.dto.user_dto.UserDto;
import com.example.pejon.repository.RoleRepository;
import com.example.pejon.repository.UserRepository;
import com.example.pejon.service.UserService;
import com.example.pejon.service.convertor.UserConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserConvertor userConvertor;
    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return userConvertor.convertToUserDto(user.get());
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userConvertor::convertToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setName(userCreateDto.name());
        user.setLogin(userCreateDto.login());
        user.setPassword(userCreateDto.password());
        Role role = roleRepository.findById(userCreateDto.roleId())
                .orElseThrow(() -> new RuntimeException("Роль с id " + userCreateDto.roleId() + " не найдена"));
        user.setRole(role);
        userRepository.save(user);
        return userConvertor.convertToUserDto(user);
    }

    @Override
    public UserDto updateUserById(Long id, UserCreateDto userCreateDto) {
        Role role = roleRepository.findById(userCreateDto.roleId())
                .orElseThrow(() -> new RuntimeException("Role с id " + id + " не найдено"));
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User с id " + id + " не найдено"));
        user.setName(userCreateDto.name());
        user.setLogin(userCreateDto.login());
        user.setPassword(userCreateDto.password());
        user.setRole(role);
        userRepository.save(user);

        return userConvertor.convertToUserDto(user);
    }

    @Override
    public void register(RegisterRequest request) {
        // Проверяем, нет ли уже пользователя с таким логином
        if (userRepository.findByLogin(request.login()).isPresent()) {
            throw new RuntimeException("User with this login already exists");
        }

        Role role = roleRepository.findById(request.roleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setName(request.name());
        user.setLogin(request.login());
        user.setPassword(passwordEncoder.encode(request.password())); // хэшируем пароль
        user.setRole(role);

        userRepository.save(user);
    }
}
