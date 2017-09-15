package com.notification.repository;


import com.notification.user.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * UserRepository reads the input file and maps the data to the User object.
 */
public class UserRepository {


    private static final String COMMA_SEPARATOR = ",";
    private static final String TRUE = "true";
    private static final String EMAIL_REGEX= "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    private File data;
    private Pattern pattern;


    public UserRepository(File data) {
        this.data = data;
        this.pattern = Pattern.compile(EMAIL_REGEX);
    }


    public List<User> getUsers() throws IOException {

        return Files
                .lines(data.toPath())
                .skip(1)
                .filter(this::isLineValid)
                .map(this::userMapper)
                .filter(this::isActive)
                .filter(this::isUserValid)
                .collect(Collectors.toList());

    }

    boolean isLineValid(String line) {
        return (!line.isEmpty() && line.split(COMMA_SEPARATOR).length == 5);
    }

    boolean isUserValid(User user) {
        return isEmailValid(user.getEmail());
    }

    private boolean isEmailValid(String email) {
        return !email.isEmpty() && pattern.matcher(email).matches();
    }

    User userMapper(String line) {
        String[] userArr = line.split(COMMA_SEPARATOR);
        return new User(userArr[0], userArr[1], userArr[2], userArr[3], userArr[4]);
    }

    boolean isActive(User user) {
        return user.getActive().equalsIgnoreCase(TRUE);
    }
}