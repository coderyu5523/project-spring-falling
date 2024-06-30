package org.example.projectspringfalling.ai.chat;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final ChatService chatService;


    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatRequest.ChatMessageDTO requestDTO) {
        chatService.processMessage(requestDTO);
    }


}
