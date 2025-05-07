package com.user.service.exception;

import com.user.service.exceptions.GlobalExceptionHandler;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.payload.ApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testHandleResourceNotFoundException() {
        // Arrange
        String errorMessage = "Resource not found";
        ResourceNotFoundException exception = new ResourceNotFoundException(errorMessage);

        // Act
        ResponseEntity<ApiResponse> responseEntity = globalExceptionHandler.handleResourceNotFoundException(exception);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        ApiResponse apiResponse = responseEntity.getBody();
        assertNotNull(apiResponse);
        assertEquals(errorMessage, apiResponse.getMessage());
        assertTrue(apiResponse.isSuccess());
        assertEquals(HttpStatus.NOT_FOUND, apiResponse.getStatus());
    }
}

