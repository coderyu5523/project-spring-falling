package org.example.projectspringfalling.history;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.RestAPI.RestResponse;
import org.example.projectspringfalling._core.errors.exception.Exception404;
import org.example.projectspringfalling.song.Song;
import org.example.projectspringfalling.song.SongRepository;
import org.example.projectspringfalling.user.SessionUser;
import org.example.projectspringfalling.user.User;
import org.example.projectspringfalling.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final SongRepository songRepository;
    private final UserRepository userRepository;

    // 보관함 - 최근 감상
    public List<RestResponse.RecentSongs> getRecentSongs(Integer userId) {
        return historyRepository.findAllRecentSongs(userId);
    }

    @Transactional
    public HistoryResponse.SaveDTO saveHistory(SessionUser sessionUser, Integer songId) {
        Song song = songRepository.findById(songId).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        User user = userRepository.findById(sessionUser.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));

        Optional<History> historyOP = historyRepository.findBySongIdAndUserId(song.getId(), user.getId());

        if (historyOP.isPresent()) {
            History history = historyOP.get();
            history.update();
            return new HistoryResponse.SaveDTO(history);
        } else {
            History history = History.builder().user(user).song(song).build();
            historyRepository.save(history);
            return new HistoryResponse.SaveDTO(history);
        }
    }
}
