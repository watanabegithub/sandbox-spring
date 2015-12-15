package sample.springbootweb;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.AssertionErrors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import sample.springbootweb.App;

import javax.servlet.Filter;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by k_watanabe on 2015/11/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = App.class)
public class AppTest {
    @Autowired
    private WebApplicationContext context;
//    @Autowired
//    private SecurityContext securityContext;

//    @Autowired
//    private Filter springSecurityFilterChain;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
//                .addFilter(springSecurityFilterChain)
                .build();
    }

    @Test
    public void ログインせずにルートページへアクセス() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
    @Test
    public void ログインせずにハローページへアクセス() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().is3xxRedirection());
    }
    @Test
    @WithMockUser(username="test@user")
    public void ログインしてハローページへアクセス() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username="user@user", roles="USER")
    public void 一般ユーザーで管理者ページへアクセス() throws Exception {
        mockMvc.perform(get("/admin/adminPage"))
//                .andExpect(status().isForbidden());
                .andExpect(status().is4xxClientError());
    }
    @Test
    @WithMockUser(username="admin@user", roles="ADMIN")
    public void 管理者ーザーで管理者ページへアクセス() throws Exception {
        mockMvc.perform(get("/admin/adminPage"))
                .andExpect(status().isOk());
    }
    @Test
    public void ログインページのテスト() throws Exception {
        mockMvc.perform(
                    formLogin()
                        .user("username", "test@user")
                        .password("password", "test")
                        .loginProcessingUrl("/login_page")
                ).andExpect(status().isFound())
                .andExpect(
                    authenticated()
                        .withUsername("test_user")
                        .withRoles("USER")
                );
    }
}
