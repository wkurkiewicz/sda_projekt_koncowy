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
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;

    @GetMapping
    @RequestMapping("/users")
    public String getAddUserView (Model model, @RequestParam(value="message", required = false) String message){
        if (message != null){
            model.addAttribute("message", message);
        }
        model.addAttribute("newUser",new UserDto());
        List<String> usersList = Arrays.stream(UserType.values()).map(userType -> userType.name()).toList();
        model.addAttribute("userTypes",  usersList);
        return "add-user";
    }
    @PostMapping
    @RequestMapping("/users/add")
    public ModelAndView addUser(UserDto userDto, @RequestParam(value = "image", required = false) MultipartFile file) {
        if (userDto.getFirstName().length() < 2 || userDto.getFirstName().length() > 30){
            ModelAndView model = new ModelAndView("redirect:/admin/users");
            model.addObject("message", "Imię powinno mieć długość pomiędzy 3 a 30 znaków");
            return model;
        }
        if (userDto.getLastName().length() < 2 || userDto.getLastName().length() > 40){
            ModelAndView model = new ModelAndView("redirect:/admin/users");
            model.addObject("message", "Nazwisko powinno mieć długość pomiędzy 3 a 30 znaków");
            return model;
        }
        userDto.setImageName(file.getOriginalFilename());
        userService.addUser(userDto, file);
        return new ModelAndView("redirect:/admin/users");
    }
}
