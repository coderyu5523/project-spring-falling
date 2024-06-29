package org.example.projectspringfalling.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.projectspringfalling._core.utils.PhoneUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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

    private MockHttpSession session;


    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
        this.session = new MockHttpSession(); // 세션 초기화
    }

    @Test
    public void join_test() throws Exception {
        // given
        UserRequest.JoinDTO requestDTO = new UserRequest.JoinDTO();
        requestDTO.setEmail("test@example.com");
        requestDTO.setPassword("password123");
        requestDTO.setPhone(PhoneUtil.formatPhoneNumber("01012345678")); // phone 설정
        requestDTO.setBirth("2000-01-01");
        requestDTO.setCreatedAt(Timestamp.from(Instant.now()));

        // when & then
        mockMvc.perform(post("/join")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", requestDTO.getEmail())
                        .param("password", requestDTO.getPassword())
                        .param("phone", requestDTO.getPhone())
                        .param("birth", requestDTO.getBirth())
                        .param("createdAt", requestDTO.getCreatedAt().toString()))
                .andExpect(status().is3xxRedirection())   // http 검증용. 리다이렉션이면 302,
                .andExpect(redirectedUrl("/login-form"));  // 리다이렉션 주소


        // 추가적으로 모델 데이터 검증, 도커 켜야 테스트 가능한듯. 나중에 티스트 해봐야지
        mockMvc.perform(MockMvcRequestBuilders.get("/login-form"))  // 가입 후 로그인 페이지 접속
                .andExpect(MockMvcResultMatchers.status().isOk())    // HTTP 상태 코드 검증
                .andExpect(MockMvcResultMatchers.model().attributeExists("message")) // 모델에 message 속성이 있는지 검증
                .andExpect(MockMvcResultMatchers.model().attribute("message", "회원 가입이 완료되었습니다.")); // message 값 검증

    }



    // todo : 로그인시 리다이렉션 302 맞는데 자꾸 200 떠서 오류남.
    @Test
    public void login_test() throws Exception {
        //given
        UserRequest.LoginDTO requestDTO = new UserRequest.LoginDTO();
        requestDTO.setEmail("test@example.com");
        requestDTO.setPassword("password123");

        // when
        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", requestDTO.getEmail())
                        .param("password", requestDTO.getPassword())
                        .session(session))
                .andExpect(status().is3xxRedirection())   // http 검증용. 리다이렉션이면 302, 성공이면 200 , 근데 이건 왜 200인지 모르겟음
                .andExpect(redirectedUrl("/"));  // 리다이렉션 주소
    }

}
