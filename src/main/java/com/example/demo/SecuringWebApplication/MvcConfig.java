package com.example.demo.SecuringWebApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/SecuringWebApplication//home").setViewName("SecuringWebApplication/home");
    registry.addViewController("/SecuringWebApplication").setViewName("SecuringWebApplication/home");
    registry.addViewController("/SecuringWebApplication/hello").setViewName("SecuringWebApplication/hello");
    registry.addViewController("/SecuringWebApplication/login").setViewName("SecuringWebApplication/login");
  }

}