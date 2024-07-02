package org.example.projectspringfalling.song;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.assertj.core.api.Assertions;
import org.example.projectspringfalling.user.SessionUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@AutoConfigureMockMvc
public class SongControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    private MockHttpSession session;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
        this.session = new MockHttpSession(); // 세션 초기화
    }

    @Test
    public void index_test() throws Exception {
        //given
        // 메인은 given 값 없음
        //when
        mockMvc.perform(get("/"))
                .andExpect(status().isOk()) // 200 이면 이렇게 함
                .andExpect(view().name("index")); // 리다이렉션 말고 페이지를 반환할 때
    }

    @Test
    public void song_detail_test() throws Exception {
        //given
        Integer songId = 1;
        session.setAttribute("sessionUser", SessionUser.builder().id(1).build());
        //when
        MvcResult result = mockMvc.perform(get("/songs/{songId}", songId).session(session))
                .andExpect(status().isOk()) // 200 이면 이렇게 함
                .andExpect(view().name("song/song-detail")).andReturn(); // 리다이렉션 말고 페이지를 반환할 때

        HttpServletRequest request = result.getRequest();
        SongResponse.DetailDTO detailDTO = (SongResponse.DetailDTO) request.getAttribute("song");
        Assertions.assertThat(detailDTO.getSongId()).isEqualTo(1);
    }
}
