//package com.user.service.entity;
//
//
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class UserTest {
//
//    @Test
//    public void testUserCreation() {
//        // Create a User object using the builder
//        User user = User.builder()
//                .userId(1L)
//                .name("John Doe")
//                .email("john.doe@example.com")
//                .about("A sample user")
//                .build();
//
//        // Validate the User object properties
//        assertEquals(1L, user.getUserId());
//        assertEquals("John Doe", user.getName());
//        assertEquals("john.doe@example.com", user.getEmail());
//        assertEquals("A sample user", user.getAbout());
//        assertNotNull(user.getRatings());
//        assertTrue(user.getRatings().isEmpty());
//    }
//
//    @Test
//    public void testUserRatings() {
//        // Create a User object
//        User user = new User();
//        user.setUserId(2L);
//        user.setName("Jane Doe");
//        user.setEmail("jane.doe@example.com");
//        user.setAbout("Another sample user");
//
//        // Add a rating to the User
//        Rating rating = new Rating();
//        user.getRatings().add(rating);
//
//        // Validate the ratings list
//        assertNotNull(user.getRatings());
//        assertEquals(1, user.getRatings().size());
//        assertSame(rating, user.getRatings().get(0));
//    }
//}
//
