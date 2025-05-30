package com.example.pejon.service.convertor;

import com.example.pejon.model.Cell;
import com.example.pejon.model.User;
import com.example.pejon.model.dto.CellDto;
import com.example.pejon.model.dto.UserDto;
import com.example.pejon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {
    @Autowired
    UserRepository userRepository;

    public UserDto convertToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getLogin(),
                user.getRole()
        );
    }
}
