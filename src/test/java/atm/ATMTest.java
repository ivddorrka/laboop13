package atm;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {
    ByteArrayOutputStream data = new ByteArrayOutputStream();
    ATM atm;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.setOut(new PrintStream(data));
        atm = new ATM();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @org.junit.jupiter.api.Test
    public void processSuccessTest() {
        atm.process(125);
        assertTrue(data.toString().contains("Your amount of money is 1 out of 5 UAH bills."));
        assertTrue(data.toString().contains("Your amount of money is 0 out of 10 UAH bills."));
        assertTrue(data.toString().contains("Your amount of money is 6 out of 20 UAH bills."));
    }

    @org.junit.jupiter.api.Test
    public void processExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> { atm.process(123); });

    }
}