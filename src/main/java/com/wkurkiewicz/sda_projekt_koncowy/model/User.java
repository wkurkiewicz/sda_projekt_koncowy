package com.wkurkiewicz.sda_projekt_koncowy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;



@Entity
@AllArgsConstructor
@Data
@Builder
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 2, max = 30)
    @Column(name = "first_name")
    private String firstName;
    @Size(min = 2, max = 40)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "active")
    private Boolean isActive = true;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;
    //Spring Hibernate zmapuje to z imageName -> image_name

    private String imageName;



    public User(String firstName, String lastName, String email, UserType userType, String imageName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.imageName = imageName;
        this.userType = userType;

    }
}
