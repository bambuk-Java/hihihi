package ch.zli.yr.goonfooder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoonFooderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoonFooderApplication.class, args);

        String rawPassword = "test123";
        String hash = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(rawPassword);
        System.out.println(hash);
    }

}
