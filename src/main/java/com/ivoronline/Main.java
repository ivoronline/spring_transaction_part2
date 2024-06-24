package com.ivoronline;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) throws Exception {

      ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
                                     context.registerShutdownHook();

      PersonService personService = context.getBean("personService", PersonService.class);
                    personService.insertRecords();

      context.close();

  }

}