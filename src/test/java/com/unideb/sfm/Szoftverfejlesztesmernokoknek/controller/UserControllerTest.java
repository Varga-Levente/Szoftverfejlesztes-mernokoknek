package com.unideb.sfm.Szoftverfejlesztesmernokoknek.controller;

import com.unideb.sfm.Szoftverfejlesztesmernokoknek.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UserControllerTest {
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    byte[] bytes = {0x02, 0x01, 0x00};

    /*@Test
    public void testGetUser() throws Exception {
        List<User> users = Arrays.asList(
                new User(
                        1234567891,
                        "Tiba Janos",
                        "Janos",
                        "janos@gmail.com",
                        "valamierdekes",
                        bytes,

                ),
                new User(
                        1234567890,
                        "Magyari Balazs",
                        "Balazs",
                        "balu@gmail.com",
                        "valami",
                        bytes,
                        ROLE_USER
                )
        );

        when(userService.getAll()).thenReturn(users);

        mockMvc.perform(get("/api/v1/user/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].fullName").value("Tiba Janos"))
                .andExpect(jsonPath("$[1].fullName").value("Magyari Balazs"));
    }

    @Test
    public void testAddUser() throws Exception {
        User user = new User(
                1234567892,
                "Tiba Janos",
                "Janos",
                "janos@gmail.com",
                "gasdfghjk",
                bytes,
                ROLE_USER
        );

        List<User> userList = Collections.singletonList(user);

        when(userService.addUser(any())).thenAnswer(invocation -> {
           List<User> addedUsers = invocation.getArgument(0);
           return ResponseEntity.ok("User added successfully");
        });

        mockMvc.perform(post("/api/v1/user/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(userList)))
                .andExpect(status().isOk())
                .andExpect(content().string("User added successfully"));
    }*/
}
