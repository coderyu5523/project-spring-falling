package org.example.projectspringfalling.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final AdminRepository adminRepository;
}
