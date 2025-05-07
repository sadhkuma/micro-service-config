package com.user.service.exception;

import org.junit.jupiter.api.Test;

import com.user.service.exceptions.ResourceNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class ResourceNotFoundExceptionTest {

    @Test
    public void testResourceNotFoundException() {
        // Arrange
        String errorMessage = "Resource not found";

        // Act
        ResourceNotFoundException exception = new ResourceNotFoundException(errorMessage);

        // Assert
        assertNotNull(exception);
        assertEquals(errorMessage, exception.getMessage());
    }
}
