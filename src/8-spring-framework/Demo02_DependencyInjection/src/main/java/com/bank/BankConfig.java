package com.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankConfig {

    // Spring matches the parameter name 'creditCardService' to your CreditCardService bean
    @Bean
    public OrderService creditCardOrderService(PaymentService creditCardService) {
        return new OrderService(creditCardService);
    }

    // Spring matches the parameter name 'debitCardService' to your DebitCardService bean
    @Bean
    public OrderService debitCardOrderService(PaymentService debitCardService) {
        return new OrderService(debitCardService);
    }
}