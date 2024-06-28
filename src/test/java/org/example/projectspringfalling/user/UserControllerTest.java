package org.example.projectspringfalling.user;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class, RestDocumentationExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Import(TestRedisConfig.class)
@Transactional
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    private RestDocumentationResultHandler document;

    @BeforeEach
    public void setup(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.document = MockMvcRestDocumentation.document("{class-name}/{method-name}",
                Preprocessors.preprocessRequest(Preprocessors.prettyPrint()),
                Preprocessors.preprocessResponse(Preprocessors.prettyPrint()));

        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilter(new CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true))
                .apply(MockMvcRestDocumentation.documentationConfiguration(restDocumentation))
                .alwaysDo(document)
                .build();
    }

    @Test
    public void join_success() throws Exception {
        // Mock request to join API
        mvc.perform(post("/api/join")
                        .contentType("application/json")
                        .content("{\"username\":\"testuser\", \"password\":\"password\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void join_fail() throws Exception {
        // Mock request to join API with invalid data
        mvc.perform(post("/api/join")
                        .contentType("application/json")
                        .content("{\"username\":\"\", \"password\":\"password\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void login_success() throws Exception {
        // Mock request to login API
        mvc.perform(post("/api/login")
                        .contentType("application/json")
                        .content("{\"username\":\"testuser\", \"password\":\"password\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void login_fail() throws Exception {
        // Mock request to login API with invalid data
        mvc.perform(post("/api/login")
                        .contentType("application/json")
                        .content("{\"username\":\"wronguser\", \"password\":\"wrongpassword\"}"))
                .andExpect(status().isUnauthorized());
    }
}
