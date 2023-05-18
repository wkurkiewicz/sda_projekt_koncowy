package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String firstName;
    private String lastName;

    private String email;
    @AssertTrue
    private boolean isPremium;
}
