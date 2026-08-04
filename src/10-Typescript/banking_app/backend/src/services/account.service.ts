import type {Account} from "../models/account"


export class AccountService implements Account{
    id = 1;
    name = "Sukanta";
    age = 24;
    
    withdraw(amount: number):void {
        console.log("Amount Withdrawn: ", amount);
        
    }
    
    deposit(amount: number):void {
        console.log("Amount Deposited: ", amount);
        
    }

    getUserDetails(): string{
        return "Id"+this.id+", Name: "+this.name+", Age: "+this.age;
    }
}
