package org.example.projectspringfalling.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.projectspringfalling._core.utils.PhoneUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void join_test() throws Exception {
        // given
        UserRequest.JoinDTO joinDTO = new UserRequest.JoinDTO();
        joinDTO.setEmail("test@example.com");
        joinDTO.setPassword("password123");
        joinDTO.setPhone(PhoneUtil.formatPhoneNumber("01012345678")); // phone 설정
        joinDTO.setBirth("2000-01-01");
        joinDTO.setCreatedAt(Timestamp.from(Instant.now()));

        // when & then
        mockMvc.perform(post("/join")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", joinDTO.getEmail())
                        .param("password", joinDTO.getPassword())
                        .param("phone", joinDTO.getPhone())
                        .param("birth", joinDTO.getBirth())
                        .param("createdAt", joinDTO.getCreatedAt().toString()))
                    .andExpect(status().is3xxRedirection())   // http 검증용. 리다이렉션이면 302
                    .andExpect(redirectedUrl("/login-form"));  // 리다이렉션 주소

        // 추가 검증
        User savedUser = userRepository.findByEmail("test@example.com");
        assertNotNull(savedUser, "User should be saved and not null");
        assertEquals("test@example.com", savedUser.getEmail());
    }

}
