package com.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        ApplicationContext context = 
            new ClassPathXmlApplicationContext( "applicationContext.xml");

        // Retrieve bean
        CustomerDAO customerDAO = 
                (CustomerDAO) context.getBean("customerDAO", CustomerDAO.class);

        // Call method to fetch cust records
        customerDAO.selectAllRows();
    }
}

