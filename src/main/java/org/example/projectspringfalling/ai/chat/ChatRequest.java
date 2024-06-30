package org.example.projectspringfalling.ai.chat;

import lombok.Data;

public class ChatRequest {

    @Data
    public static class ChatMessageDTO {
        private String content;

    }

}
