package org.example.projectspringfalling.admin;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.user.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    public AdminResponse.UserListDTO getUserList() {
        return new AdminResponse.UserListDTO(userRepository.findUserList());
    }

}
