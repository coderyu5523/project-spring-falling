package org.example.projectspringfalling.history;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.RestAPI.RestResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    // 보관함 - 최근 감상
    public List<RestResponse.RecentSongs> getRecentSongs(Integer userId) {
        return historyRepository.findAllRecentSongs(userId);
    }
}
