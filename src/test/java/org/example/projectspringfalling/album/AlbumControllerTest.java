package org.example.projectspringfalling.album;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.projectspringfalling.admin.SessionAdmin;
import org.example.projectspringfalling.artist.ArtistRepository;
import org.example.projectspringfalling.song.SongRequest;
import org.example.projectspringfalling.user.SessionUser;
import org.example.projectspringfalling.user.User;
import org.example.projectspringfalling.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@Sql("classpath:db/data.sql")
public class AlbumControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    private MockHttpSession session;


    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ArtistRepository artistRepository;

    @BeforeEach
    public void setup() {
        this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
        this.session = new MockHttpSession(); // 세션 초기화
    }

    // 앨범 상세보기
    @Test
    public void songListDetail_test() throws Exception {
        // given
        Integer albumId = 1;

        // when & then
        mockMvc.perform(get("/albums/" + albumId + "/list").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("album/album-list"))
                .andExpect(model().attributeExists("album"));
    }

    // 앨범 추가하기
    @Test
    public void albumRegister_test() throws Exception {
        // given
        SessionAdmin sessionAdmin = new SessionAdmin();
        sessionAdmin.setId(1);
        session.setAttribute("sessionAdmin", sessionAdmin);
        AlbumRequest.SaveDTO requestDTO = new AlbumRequest.SaveDTO();
        requestDTO.setTitle("Test Album");
        requestDTO.setIntro("This is a test album");
        requestDTO.setAgency("Test Agency");
        requestDTO.setDistributor("Test Distributor");
        requestDTO.setCategory("Test Category");
        requestDTO.setNationality("Test Nationality");

        // Mock MultipartFile 생성
        MockMultipartFile albumImg = new MockMultipartFile(
                "albumImg",
                "test-album.jpg",
                "image/jpeg",
                "test image content".getBytes(StandardCharsets.UTF_8)
        );

        // Mock song list
        List<SongRequest.SaveDTO> songList = new ArrayList<>();
        SongRequest.SaveDTO song = new SongRequest.SaveDTO();
        song.setTitle("Test Song");
        song.setLyrics("Test Lyrics");
        songList.add(song);
        requestDTO.setSongList(songList);

        // ObjectMapper를 사용해 JSON 문자열로 변환
        String requestDTOJson = objectMapper.writeValueAsString(requestDTO);

        // when & then
        mockMvc.perform(multipart("/albums/register")
                        .file(albumImg)
                        .param("title", requestDTO.getTitle())
                        .param("intro", requestDTO.getIntro())
                        .param("agency", requestDTO.getAgency())
                        .param("distributor", requestDTO.getDistributor())
                        .param("category", requestDTO.getCategory())
                        .param("nationality", requestDTO.getNationality())
                        .param("songList", requestDTOJson)
                        .session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/albums"));
    }
}
