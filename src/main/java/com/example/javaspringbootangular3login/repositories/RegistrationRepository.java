package com.example.javaspringbootangular3login.repositories;

import com.example.javaspringbootangular3login.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);

}
