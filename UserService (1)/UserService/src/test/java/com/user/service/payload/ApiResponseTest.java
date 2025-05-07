package com.user.service.payload;



import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

public class ApiResponseTest {

    @Test
    public void testApiResponse() {
        // Arrange
        String message = "Operation successful";
        boolean success = true;
        HttpStatus status = HttpStatus.OK;

        // Act
        ApiResponse apiResponse = ApiResponse.builder()
                .message(message)
                .success(success)
                .status(status)
                .build();

        // Assert
        assertNotNull(apiResponse);
        assertEquals(message, apiResponse.getMessage());
        assertTrue(apiResponse.isSuccess());
        assertEquals(status, apiResponse.getStatus());
    }
}
