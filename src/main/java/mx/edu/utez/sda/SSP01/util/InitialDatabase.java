package mx.edu.utez.sda.SSP01.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class InitialDatabase implements CommandLineRunner {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        String myPass = "123456";
        String encode = passwordEncoder.encode(myPass);
        System.out.println(encode);
    }
}
