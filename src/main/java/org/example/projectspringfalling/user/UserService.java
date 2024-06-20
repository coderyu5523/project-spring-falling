package org.example.projectspringfalling.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User login(UserRequest.LoginDTO reqDTO) throws Exception {
        User sessionUser = userRepository.findByEmailAndPassword(reqDTO.getEmail(), reqDTO.getPassword())
                .orElseThrow(() -> new Exception("인증되지 않았습니다."));
        return sessionUser;
    }
}
