package dev.gisela;

public class CheckingAccount extends Account {
    float overdraft;

    public CheckingAccount(float balance, float rate) {
        super(balance, rate);
        overdraft = 0;
    }

    public void withdraw(float amount) {
        float result = balance - amount;
        if (result < 0) {
            overdraft = overdraft - result;
            balance = 0;
        } else {
            super.withdraw(amount);
        }
    }

    public void deposit(float amount) {
        float remainder = overdraft - amount;
        if (overdraft > 0) {
            if (remainder > 0) {
                overdraft = 0;
                balance = remainder;
            } else {
                overdraft = -remainder;
                balance = 0;
            }
        } else {
            super.deposit(amount);
        }
    }

    public void monthlyStatement() {
        super.monthlyStatement();
    }

    public void print() {
        System.out.println("Balance = $ " + balance);
        System.out.println("Monthly fee = $ " + monthlyFee);
        System.out.println("Number of transactions = " + (numberOfDeposits + numberOfWithdrawals));
        System.out.println("Overdraft amount = $" + overdraft);
        System.out.println();
 
   }



}
