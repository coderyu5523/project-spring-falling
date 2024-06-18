package org.example.projectspringfalling.history;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class HistoryController {
    private final HistoryService historyService;
    private final HttpSession session;

}
