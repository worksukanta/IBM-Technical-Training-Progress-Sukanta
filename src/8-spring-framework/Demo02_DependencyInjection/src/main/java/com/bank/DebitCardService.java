package com.bank;

import org.springframework.stereotype.Service;

@Service
public class DebitCardService implements PaymentService{
    @Override
    public void withdrawMoney(double amount){
        System.out.println("Amount Debitted through Debit Card: "+amount);
    }
}
