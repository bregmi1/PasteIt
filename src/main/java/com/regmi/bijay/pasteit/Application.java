package com.regmi.bijay.pasteit;


import com.regmi.bijay.pasteit.accessors.IPasteAccessor;
import com.regmi.bijay.pasteit.accessors.IUserAccessor;
import com.regmi.bijay.pasteit.domains.Paste;
import com.regmi.bijay.pasteit.domains.User;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;


@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Bean
    public CommandLineRunner startup(IPasteAccessor pasteAccessor, IUserAccessor userAccessor){
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                User user = new User();
                user.setName("Test User ");
                user.setEmail("test@example2.com");
                user.setPassword("password123A");

                LocalDateTime now = LocalDateTime.now();
                user.setCreatedOn(now);
                user.setUpdateOn(now);
                LOGGER.info("Created new user: {}", user);

                Paste paste = new Paste();
                paste.setBody("This is the body of the paste");
                paste.setUser(user);
                paste.setCreatedOn(now);
                paste.setUpdatedOn(now);
                paste.setExpiresOn(now.plusDays(1));
                LOGGER.info("Created new Paste: {}", paste);

                LOGGER.info("All pastes: " + pasteAccessor.findAll());
                LOGGER.info("All users: " + userAccessor.findAll());

                userAccessor.save(user);
                LOGGER.info("All users after adding test user: " + userAccessor.findAll());

                pasteAccessor.save(paste);
                LOGGER.info("All pastes after adding the test paste: " + pasteAccessor.findAll());

                LOGGER.info("All the pastes by test user: " + pasteAccessor.findAllByUser(user));

                LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
                LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);

                LOGGER.info("All the pastes that expires between yesterday and tomorrow: " + pasteAccessor.findAllByExpiresOnAfterAndExpiresOnBefore(yesterday, tomorrow));
                LOGGER.info("All the pastes that expires before tomorrow: " + pasteAccessor.findAllByExpiresOnBefore(tomorrow));

                LOGGER.info("The user with email test@example.com: " + userAccessor.findByEmail("test@example.com"));
                LOGGER.info("All the users created between yesterday and tomorrow: " + userAccessor.findAllByCreatedOnAfterAndCreatedOnBefore(yesterday, tomorrow));

            }
        };
    }
}
