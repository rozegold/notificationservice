package com.notification.repository;

import com.notification.user.User;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class UserRepositoryTest {


    private UserRepository repository;
    private User user;
    private String valid_line = "1,true,email,test1@mail.com,+999999999999";
    private String invalid_line = "1,true,emailtest1@mail.com,+999999999999";
    private String invalid_email = "1,true,email,test1mail.com,+999999999999";

    public UserRepositoryTest() throws IOException {
    }

    @Before
    public void setUp() {
        repository = new UserRepository(new File(this.getClass().getResource("/test_user_data.txt").getFile()));
        user = repository.userMapper(valid_line);
    }

    @Test
    public void testGetUsers() throws IOException {

        List<User> listOfUsers = repository.getUsers();
        assertEquals(4, listOfUsers.size());
    }

    @Test
    public void testValidLine() {
        assertEquals(true, repository.isLineValid(valid_line));
        assertEquals(false, repository.isLineValid(invalid_line));
    }

    @Test
    public void testUserMapper() {
        assertEquals("test1@mail.com", user.getEmail());
    }

    @Test
    public void testActive() {
        assertEquals(true, repository.isActive(user));
    }

    @Test
    public void testValidUser() {
        assertEquals(true, repository.isUserValid(user));

        user = repository.userMapper(invalid_email);
        assertEquals(false, repository.isUserValid(user));
    }


}