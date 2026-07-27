package com.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component
public class OrderService{
    private final PaymentService paymentService;

    // @Autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void withdrawFunds(double amount) {
        System.out.println("Withdrawl of " + amount + " Initiated... ");
        paymentService.withdrawMoney(amount);
    }
}

