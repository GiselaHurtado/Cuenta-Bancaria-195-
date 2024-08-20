package dev.gisela;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void testDeposit() {
        Account account = new Account(1000, 0.05f);
        account.deposit(500);
        assertEquals(1500, account.balance);
        assertEquals(1, account.numberOfDeposits);
    }

    @Test
    void testWithdraw() {
        Account account = new Account(1000, 0.05f);
        account.withdraw(500);
        assertEquals(500, account.balance);
        assertEquals(1, account.numberOfWithdrawals);
    }

    @Test
    void testWithdrawExceedsBalance() {
        Account account = new Account(1000, 0.05f);
        account.withdraw(1500);
        assertEquals(1000, account.balance);
        assertEquals(0, account.numberOfWithdrawals);
    }

    @Test
    void testCalculateInterest() {
        Account account = new Account(1200, 0.12f);
        account.calculateInterest();
        assertEquals(1212, account.balance, 0.01);
    }

    @Test
    void testMonthlyStatement() {
        Account account = new Account(1200, 0.12f);
        account.monthlyFee = 50;
        account.monthlyStatement();
        assertEquals(1161.5, account.balance, 0.01);
    }
}
