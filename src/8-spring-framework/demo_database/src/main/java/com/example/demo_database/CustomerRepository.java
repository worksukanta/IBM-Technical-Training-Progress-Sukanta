package com.example.demo_database;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Derived query to find customers by account type
    List<Customer> findByAccountType(String accountType);
}

