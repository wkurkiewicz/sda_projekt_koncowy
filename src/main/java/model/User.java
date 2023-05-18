package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
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
    @Size(min = 2, max = 20)
    @Column(name = "first_name")
    private String firstName;
    @Size(min = 2, max = 20)
    private String lastName;
    private String email;
    private boolean isActive = true;
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
