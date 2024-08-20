package dev.gisela;

public class Account {
  
    protected float balance;

    protected int numberOfDeposits = 0;
  
    protected int numberOfWithdrawals = 0;
 
    protected float annualInterestRate;
 
    protected float monthlyFee = 0;

    
    
    public Account(float balance, float annualInterestRate) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

   
    public void deposit(float amount) {
        balance = balance + amount; 
        numberOfDeposits = numberOfDeposits + 1;
    }

  
    public void withdraw(float amount) {
        float newBalance = balance - amount;
     
        if (newBalance >= 0) {
            balance -= amount;
            numberOfWithdrawals = numberOfWithdrawals + 1;
        } else {
            System.out.println("The amount to withdraw exceeds the current balance.");
        }
    }

 
public void calculateInterest() {
    float monthlyRate = annualInterestRate / 12; 
    float monthlyInterest = balance * monthlyRate;
    balance += monthlyInterest; 
}


public void monthlyStatement() {
    balance -= monthlyFee;
    calculateInterest();
}
}




