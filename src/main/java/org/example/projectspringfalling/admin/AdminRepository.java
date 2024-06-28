package org.example.projectspringfalling.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
