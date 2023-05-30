package com.wkurkiewicz.sda_projekt_koncowy.service;

import com.wkurkiewicz.sda_projekt_koncowy.dto.UserDto;
import com.wkurkiewicz.sda_projekt_koncowy.model.User;
import com.wkurkiewicz.sda_projekt_koncowy.model.UserType;
import com.wkurkiewicz.sda_projekt_koncowy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(u -> new UserDto(u.getId(),u.getFirstName(), u.getLastName(), u.getEmail(), u.getUserType(), u.getImageName(), null)).toList();
    }
    public void addUser(UserDto userDto, MultipartFile file) {
        User user = new User (userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), UserType.valueOf(userDto.getSelectedUserType()));
        userRepository.save(user);
        saveUserImage(file);
    }

    private void saveUserImage(MultipartFile file) {

        Path uploads = Paths.get("./uploads");
        try {
            Files.copy(file.getInputStream(), uploads.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
