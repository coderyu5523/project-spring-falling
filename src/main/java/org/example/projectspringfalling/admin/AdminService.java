package org.example.projectspringfalling.admin;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.user.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    // 유저 상세보기
    public AdminResponse.UserDetailDTO getUser(int userId) {
        return userRepository.findOneUserById(userId);
    }

    // 유저 목록보기
    public AdminResponse.UserListDTO getUserList() {
        return new AdminResponse.UserListDTO(userRepository.findUserList());
    }

}
