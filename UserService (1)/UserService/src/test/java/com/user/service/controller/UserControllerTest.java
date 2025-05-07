package com.user.service.controller;


import com.user.service.entity.User;
import com.user.service.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        User user = User.builder()
                .userId(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .about("A sample user")
                .build();

        when(userService.saveUser(any(User.class))).thenReturn(user);

        ResponseEntity<User> response = userController.createUser(user);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testGetAllUsers() {
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

        ResponseEntity<List<User>> response = userController.getAllUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(users, response.getBody());
    }

    @Test
    public void testGetUserById() {
        User user = User.builder()
                .userId(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .about("A sample user")
                .build();

        when(userService.getUser(1L)).thenReturn(user);

        ResponseEntity<User> response = userController.getUserById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testRatingHotelFallback() {
        User fallbackUser = User.builder()
                .userId(45L)
                .name("Dummy")
                .email("dummy@gmail.com")
                .about("This user is created dummy because some service is down")
                .build();

        ResponseEntity<User> response = userController.ratingHotelFallback(1L, new Exception("Service down"));

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(fallbackUser, response.getBody());
    }
}
