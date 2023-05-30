package com.wkurkiewicz.sda_projekt_koncowy.controller;

import com.wkurkiewicz.sda_projekt_koncowy.dto.UserDto;
import com.wkurkiewicz.sda_projekt_koncowy.model.UserType;
import com.wkurkiewicz.sda_projekt_koncowy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;

    @GetMapping
    @RequestMapping("/users")
    public String getAddUserView (Model model){
        model.addAttribute("newUser",new UserDto());
        List<String> usersList = Arrays.stream(UserType.values()).map(userType -> userType.name()).toList();
        model.addAttribute("userTypes",  usersList);
        return "add-user";
    }
    @PostMapping
    @RequestMapping("/users/add")
    public String addUser(UserDto userDto, @RequestParam(value = "image", required = false) MultipartFile file) {
        userDto.setImageName(file.getOriginalFilename());
        userService.addUser(userDto, file);
        return "redirect:/admin/users";
    }
}
