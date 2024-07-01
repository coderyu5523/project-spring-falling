package org.example.projectspringfalling.admin;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.projectspringfalling.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {

    @Autowired
    private UserRepository userRepository;

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

        // 관리자 로그인
        try {
            mockMvc.perform(post("/admin/login")
                            .param("email", "admin1@nate.com")
                            .param("password", "1234")
                            .session(session))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(redirectedUrl("/admin/albums"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 엘범 상세보기
    @Test
    public void albumDetail_test() throws Exception {
        Integer albumId = 1;

        mockMvc.perform(get("/admin/albums/" + albumId).session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/album-detail"))
                .andExpect(model().attributeExists("album"));
    }

    // 앨범 목록보기
    @Test
    public void albumList_test() throws Exception {
        mockMvc.perform(get("/admin/albums").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/album-list"))
                .andExpect(model().attributeExists("albumList"));
    }

    // 가수 상세보기
    @Test
    public void artistDetail_test() throws Exception {
        Integer artistId = 1;

        mockMvc.perform(get("/admin/artists/" + artistId).session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/artist-detail"))
                .andExpect(model().attributeExists("artist"));
    }

    // 가수 목록보기
    @Test
    public void artistList_test() throws Exception {
        mockMvc.perform(get("/admin/artists").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/artist-list"))
                .andExpect(model().attributeExists("artistList"));
    }
}
