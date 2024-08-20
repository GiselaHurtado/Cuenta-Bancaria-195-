package dev.gisela;

public class SavingsAccount extends Account {
  
    private boolean active;

 
    public SavingsAccount(float balance, float rate) {
        super(balance, rate);
        if (balance < 10000) 
            active = false;
        else
            active = true;
    }


    public void withdraw(float amount) {
        if (active)
            super.withdraw(amount);
    }

 
    public void deposit(float amount) {
        if (active)
            super.deposit(amount); 
    }

   
    public void monthlyStatement() {
       
        if (numberOfWithdrawals > 4) {
            monthlyFee += (numberOfWithdrawals - 4) * 1000;
        }
        super.monthlyStatement(); 
                if (balance < 10000)
            active = false;
    }


    public void print() {
        System.out.println("Balance = $ " + balance);
        System.out.println("Monthly fee = $ " + monthlyFee);
        System.out.println("Number of transactions = " + (numberOfDeposits + numberOfWithdrawals));
        System.out.println();
    }
}

