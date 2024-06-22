package org.example.projectspringfalling.admin;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.song.SongRepository;
import org.example.projectspringfalling.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    private final SongRepository songRepository;

    // 곡 상세보기
    public AdminResponse.SongDetailDTO getSong(Integer songId) {
        return songRepository.findOneSongById(songId);
    }

    // 곡 리스트
    public List<AdminResponse.SongListDTO> getSongList() {
        return songRepository.findSongList();
    }

    // 유저 상세보기
    public AdminResponse.UserDetailDTO getUser(int userId) {
        return userRepository.findOneUserById(userId);
    }

    // 유저 목록보기
    public AdminResponse.UserListDTO getUserList() {
        return new AdminResponse.UserListDTO(userRepository.findUserList());
    }

}
