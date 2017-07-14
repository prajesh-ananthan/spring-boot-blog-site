package com.prajesh;

import com.prajesh.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * This class shows the beans loaded upon runtime
 */

//@SpringBootApplication
public class RunBeansApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(RunBeansApplication.class, args);

    // Loaded beans within the Spring context
    String[] beanNames = ctx.getBeanDefinitionNames();
    Arrays.sort(beanNames);
    for (String bean : beanNames)
      System.out.println(bean);

    User user = (User) ctx.getBean("user");
    System.out.println(user.toString());

  }

  @TestConfiguration
  public static class TestConfig {

    @Bean
    public User user() {
      return new User("Prajesh", "Ananthan", "prajesh.ananthan@outlook.com");
    }
  }
}
