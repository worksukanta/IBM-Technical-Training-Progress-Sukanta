package com.bank;

import org.springframework.stereotype.Service;

@Service
public class CreditCardService implements PaymentService{
    @Override
    public void withdrawMoney(double amount){
        System.out.println("Amount debitted through Credit Card: "+amount);
    }
}
