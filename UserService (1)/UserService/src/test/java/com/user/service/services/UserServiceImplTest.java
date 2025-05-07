package com.user.service.services;

import com.user.service.entity.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.external.services.HotelServiceClient;
import com.user.service.payload.ApiResponse;
import com.user.service.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
     private UserRepo userRepo;
    
    private ApiResponse  apiResponse;

    @Mock
    private HotelServiceClient hotelServiceClient;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

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

        when(userRepo.save(any(User.class))).thenReturn(user);

        User savedUser = userServiceImpl.saveUser(user);

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

        when(userRepo.findAll()).thenReturn(users);

        List<User> retrievedUsers = userServiceImpl.getAllUser();

        assertNotNull(retrievedUsers);
        assertEquals(2, retrievedUsers.size());
        assertEquals(user1, retrievedUsers.get(0));
        assertEquals(user2, retrievedUsers.get(1));
    }

    
    @Test
    public void testGetUserNotFound() {
        when(userRepo.findById(1L)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            userServiceImpl.getUser(1L);
        });

        assertEquals("User with given id is not found on server: 1", exception.getMessage());
    }
}
