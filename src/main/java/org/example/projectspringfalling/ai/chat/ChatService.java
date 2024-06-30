package org.example.projectspringfalling.ai.chat;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.ai.OpenAI.OpenAIService;
import org.example.projectspringfalling.album.AlbumRepository;
import org.example.projectspringfalling.artist.ArtistRepository;
import org.example.projectspringfalling.playlist.PlaylistRepository;
import org.example.projectspringfalling.song.Song;
import org.example.projectspringfalling.song.SongRepository;
import org.example.projectspringfalling.song.SongResponse;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.example.projectspringfalling._core.utils.ChatLinkUtil.addSongLinks;


@RequiredArgsConstructor
@Service
public class ChatService {

    private final SimpMessagingTemplate messagingTemplate;
    private final OpenAIService openAIService;
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final PlaylistRepository playlistRepository;

    public void processMessage(ChatRequest.ChatMessageDTO message) {
        String userMessage = message.getContent();

        // DB에서 모든 사용자 조회
        List<Song> songs = songRepository.findByJoinAlbumAndArtist();
        String songInfo = songs.stream()
                .map(song -> new SongResponse.AIChatDTO(song))
                .map(aiChatDTO -> aiChatDTO.toString()) // AIChatDTO를 문자열로 변환
                .collect(Collectors.joining("; "));

        // OpenAI API 요청
        String prompt = userMessage + "\nCurrent songs in DB: " + songInfo;
        String aiResponse = openAIService.askOpenAI(prompt);
        // 노래 제목을 링크로 변환
        String responseWithLinks = addSongLinks(aiResponse, songs);

        // 응답 메시지 생성 및 전송
        ChatResponse.ChatMessageDTO aiMessage = new ChatResponse.ChatMessageDTO(responseWithLinks);

        messagingTemplate.convertAndSend("/topic/messages", aiMessage);
    }

}
