package mx.edu.utez.sda.SSP01.control;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("Home");
        registry.addViewController("/home").setViewName("Home");
        registry.addViewController("/privada").setViewName("Privada");
        registry.addViewController("/login").setViewName("Login");
    }

}
