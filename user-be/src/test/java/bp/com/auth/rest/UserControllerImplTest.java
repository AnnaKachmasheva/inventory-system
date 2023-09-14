package bp.com.auth.rest;

import bp.com.auth.Generator;
import bp.com.auth.models.domain.User;
import bp.com.auth.facades.UserFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.CoreMatchers.is;


import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class UserControllerImplTest {

    //todo

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserFacade userFacade;

    @Autowired
    private ObjectMapper objectMapper;

    private static Generator generator;

    @BeforeAll
    static void init() {
        generator = new Generator();
    }

    @Test
    void create() throws Exception {
        User user = generator.getUser();
        user.setPrivileges(new ArrayList<>());

        given(userFacade.create(user)).willReturn(user);

        ResultActions response = mockMvc.perform(post("/api/auth/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)));

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$.firstName",
                        is(user.getFirstName())))
                .andExpect((ResultMatcher) jsonPath("$.lastName",
                        is(user.getLastName())))
                .andExpect((ResultMatcher) jsonPath("$.email",
                        is(user.getEmail())));
    }

}