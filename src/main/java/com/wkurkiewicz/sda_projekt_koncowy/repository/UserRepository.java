package com.wkurkiewicz.sda_projekt_koncowy.repository;

import com.wkurkiewicz.sda_projekt_koncowy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
