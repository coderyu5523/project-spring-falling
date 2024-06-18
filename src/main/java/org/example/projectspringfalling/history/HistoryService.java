package org.example.projectspringfalling.history;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HistoryService {
    private final HistoryRepository historyRepository;
}
