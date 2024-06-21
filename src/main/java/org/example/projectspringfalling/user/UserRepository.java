package org.example.projectspringfalling.user;

import org.example.projectspringfalling.admin.AdminResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    User findByEmail(@Param("email") String email);

    @Query("SELECT new org.example.projectspringfalling.admin.AdminResponse$UserListDTO$UserDTO(u.id, u.email, u.provider, u.status) FROM User u")
    List<AdminResponse.UserListDTO.UserDTO> findUserList();

    @Query("SELECT new org.example.projectspringfalling.admin.AdminResponse$UserDetailDTO(u.id ,u.email,u.phone,u.birth,u.provider,u.createdAt,u.status) FROM User u WHERE u.id = :userId")
    AdminResponse.UserDetailDTO findOneUserById(Integer userId);
}
