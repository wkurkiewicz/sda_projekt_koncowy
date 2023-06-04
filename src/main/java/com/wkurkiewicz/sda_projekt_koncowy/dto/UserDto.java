package com.wkurkiewicz.sda_projekt_koncowy.dto;

import com.wkurkiewicz.sda_projekt_koncowy.model.User;
import com.wkurkiewicz.sda_projekt_koncowy.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private UserType userType;
    private String imageName;
    private String selectedUserType;
}
