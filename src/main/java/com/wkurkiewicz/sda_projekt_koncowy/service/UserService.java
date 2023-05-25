package com.wkurkiewicz.sda_projekt_koncowy.service;

import com.wkurkiewicz.sda_projekt_koncowy.dto.UserDto;
import com.wkurkiewicz.sda_projekt_koncowy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(u -> new UserDto(u.getId(),u.getFirstName(), u.getLastName(), u.getEmail(), u.getUserType())).toList();
    }
}
