package com.wkurkiewicz.sda_projekt_koncowy.controller;

import com.wkurkiewicz.sda_projekt_koncowy.dto.UserDto;
import com.wkurkiewicz.sda_projekt_koncowy.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    public String users(Model model){
        List<UserDto> usersFromDb = userService.getUsers();
        model.addAttribute("users", usersFromDb);
        return "users";
    }
}
