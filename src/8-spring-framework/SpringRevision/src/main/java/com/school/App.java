package com.school;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = (Student) context.getBean("student");
        student1.display_details();
        System.out.println( "------------------------" );

         // here Tomcat which is embedded in spring boot runs automatically
        SpringApplication.run(App.class, args); 

    }
}

