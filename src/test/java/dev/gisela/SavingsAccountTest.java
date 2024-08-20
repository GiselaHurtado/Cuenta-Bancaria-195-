package dev.gisela;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    @Test
    void testDeposit() {
        SavingsAccount account = new SavingsAccount(15000, 0.05f);
        account.deposit(500);
        assertEquals(15500, account.balance);
        assertEquals(1, account.numberOfDeposits);
    }

    @Test
    void testWithdraw() {
        SavingsAccount account = new SavingsAccount(15000, 0.05f);
        account.withdraw(500);
        assertEquals(14500, account.balance);
        assertEquals(1, account.numberOfWithdrawals);
    }

    @Test
    void testWithdrawInactive() {
        SavingsAccount account = new SavingsAccount(5000, 0.05f);
        account.withdraw(500);
        assertEquals(5000, account.balance);
        assertEquals(0, account.numberOfWithdrawals);
    }

    @Test
    void testMonthlyStatement() {
        SavingsAccount account = new SavingsAccount(15000, 0.05f);
        account.numberOfWithdrawals = 5;
        account.monthlyStatement();
        assertEquals(14058.33, account.balance, 0.01);
    }
}
