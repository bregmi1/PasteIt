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
                user.setEmail("test@example.com");
                user.setPassword("password123A");
                LOGGER.info("Created new user: {}", user);

                Paste paste = new Paste();
                paste.setBody("This is the body of the paste");
                paste.setUser(user);
                LOGGER.info("Created new Paste: {}", paste);

                LOGGER.info("All pastes: " + pasteAccessor.findAll());
                LOGGER.info("All users: " + userAccessor.findAll());
            }
        };
    }
}
