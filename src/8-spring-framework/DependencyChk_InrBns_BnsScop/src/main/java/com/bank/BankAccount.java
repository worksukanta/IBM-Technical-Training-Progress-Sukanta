package com.bank;


public class BankAccount {
   private int accountId;
   private String accountHolder;

//    BankAccount(){}

//    BankAccount(int accountId, String accountHolder){
//         this.accountId = accountId;
//         this.accountHolder = accountHolder;
//    }


   public void setAccountId(int accountId) { this.accountId = accountId; }
   public void setAccountHolder(String accountHolder) { this.accountHolder = accountHolder; }


   public void display() {
       System.out.println("Account ID: " + accountId + ", Holder: " + accountHolder);
   }
}
