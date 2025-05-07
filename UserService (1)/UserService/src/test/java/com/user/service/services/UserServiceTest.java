package com.user.service.services;

import com.user.service.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser() {
        User user = User.builder()
                .userId(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .about("A sample user")
                .build();

        when(userService.saveUser(any(User.class))).thenReturn(user);

        User savedUser = userService.saveUser(user);

        assertNotNull(savedUser);
        assertEquals(1L, savedUser.getUserId());
        assertEquals("John Doe", savedUser.getName());
        assertEquals("john.doe@example.com", savedUser.getEmail());
        assertEquals("A sample user", savedUser.getAbout());
    }

    @Test
    public void testGetAllUser() {
        User user1 = User.builder()
                .userId(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .about("A sample user")
                .build();

        User user2 = User.builder()
                .userId(2L)
                .name("Jane Doe")
                .email("jane.doe@example.com")
                .about("Another sample user")
                .build();

        List<User> users = Arrays.asList(user1, user2);

        when(userService.getAllUser()).thenReturn(users);

        List<User> retrievedUsers = userService.getAllUser();

        assertNotNull(retrievedUsers);
        assertEquals(2, retrievedUsers.size());
        assertEquals(user1, retrievedUsers.get(0));
        assertEquals(user2, retrievedUsers.get(1));
    }

    @Test
    public void testGetUser() {
        User user = User.builder()
                .userId(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .about("A sample user")
                .build();

        when(userService.getUser(1L)).thenReturn(user);

        User retrievedUser = userService.getUser(1L);

        assertNotNull(retrievedUser);
        assertEquals(1L, retrievedUser.getUserId());
        assertEquals("John Doe", retrievedUser.getName());
        assertEquals("john.doe@example.com", retrievedUser.getEmail());
        assertEquals("A sample user", retrievedUser.getAbout());
    }
}
