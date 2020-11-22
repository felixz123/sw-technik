package com.project.zulassungssystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/zulassung").setViewName("zulassung");
		registry.addViewController("/bewerber").setViewName("bewerber");
		registry.addViewController("/unterstuetzer").setViewName("unterstuetzer");
		//registry.addViewController("/login").setViewName("login");
	}

}
