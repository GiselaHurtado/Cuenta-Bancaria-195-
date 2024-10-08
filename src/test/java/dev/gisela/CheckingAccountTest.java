package dev.gisela;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {

    @Test
    void testWithdraw() {
        CheckingAccount account = new CheckingAccount(1000, 0.05f);
        account.withdraw(1500);
        assertEquals(0, account.balance);
        assertEquals(500, account.overdraft);
    }

    @Test
    void testWithdrawWithoutOverdraft() {
        CheckingAccount account = new CheckingAccount(1000, 0.05f);
        account.withdraw(500);
        assertEquals(500, account.balance);
        assertEquals(0, account.overdraft);
    }

    @Test
    void testDeposit() {
        CheckingAccount account = new CheckingAccount(1000, 0.05f);
        account.overdraft = 500;
        account.deposit(1000);
        assertEquals(0.0, account.balance);
        assertEquals(500, account.overdraft);
    }

    @Test
    void testDepositCoveringOverdraft() {
        CheckingAccount account = new CheckingAccount(0, 0.05f);
        account.overdraft = 500;
        account.deposit(600);
        assertEquals(0.0, account.balance);
        assertEquals(100, account.overdraft);
    }

    @Test
    void testDepositWithoutOverdraft() {
        CheckingAccount account = new CheckingAccount(0, 0.05f);
        account.deposit(1000);
        assertEquals(1000, account.balance);
        assertEquals(0, account.overdraft);
    }

    @Test
    void testMonthlyStatement() {
        CheckingAccount account = new CheckingAccount(1000, 0.05f);
        account.monthlyFee = 50;
        account.monthlyStatement();
        assertEquals(953.95, account.balance, 0.01);
    }

  

    @Test
    void testPrint() {
        CheckingAccount account = new CheckingAccount(1000, 0.05f);
        account.withdraw(1500);
        account.print();
       
    }

    @Test
    void testDepositCoversPartOfOverdraft() {
        CheckingAccount account = new CheckingAccount(0, 0.05f);
        account.overdraft = 600;
        account.deposit(500);
        assertEquals(100, account.balance);
        assertEquals(0.0, account.overdraft);
    }

    @Test
    void testDepositNegativeAmount() {
        CheckingAccount account = new CheckingAccount(0, 0.05f);
        account.deposit(0);
        assertEquals(0, account.balance); 
        assertEquals(0, account.overdraft); 
    }
}
