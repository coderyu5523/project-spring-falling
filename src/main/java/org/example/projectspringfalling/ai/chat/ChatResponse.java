package org.example.projectspringfalling.ai.chat;

import lombok.Data;

public class ChatResponse {

    @Data
    public static class ChatMessageDTO {
        private String content;

        public ChatMessageDTO(String aiResponse) {
            this.content = aiResponse;
        }
    }
}
