package com.notification;

import com.notification.repository.UserRepository;
import com.notification.user.User;

import java.io.File;
import java.io.IOException;

public class App {

    private static final String WELCOME_MESSAGE = "Welcome to our system";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String ALL = "all";

    public static void main(String[] args) throws IOException {

        UserRepository repository = new UserRepository(new File(args[0]));
        repository.getUsers().forEach(App::notify);
    }

    private static void notify(User user) {

        if (user.getDispatchingOption().equalsIgnoreCase(EMAIL)) {
            sendEmail(user.getEmail(), WELCOME_MESSAGE);
        } else if (user.getDispatchingOption().equalsIgnoreCase(PHONE)) {
            sendSMS(user.getPhone(), WELCOME_MESSAGE);
        } else if (user.getDispatchingOption().equalsIgnoreCase(ALL)) {
            sendEmail(user.getEmail(), WELCOME_MESSAGE);
            sendSMS(user.getPhone(), WELCOME_MESSAGE);
        }

    }


    private static void sendSMS(String to, String text) {
        System.out.println("SMS sent to " + to + " with text: " + text);
    }

    private static void sendEmail(String to, String text) {
        System.out.println("Email sent to " + to + " with text: " + text);
    }
}
