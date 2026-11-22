package dev.stefanmarkan;

import static org.junit.jupiter.api.Assertions.*;

import dev.stefanmarkan.models.Book;
import dev.stefanmarkan.models.Customer;
import dev.stefanmarkan.models.Loan;
import dev.stefanmarkan.utilities.GenderType;
import dev.stefanmarkan.utilities.LoanStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LoanTest {

    private Customer customer;
    private Book book;
    private Loan loan;

    @BeforeEach
    void initEach() {
        customer = new Customer(
                "Mr",
                "John",
                "Doe",
                "123 Fake Street, Gothenburg",
                "0701234567",
                "john.doe@example.com",
                1001,
                GenderType.MALE
        );

        book = new Book(1,
                "Learning Java",
                "",
                "",
                "",
                0);


        loan = new Loan(1, customer, book);
    }

    //G
    @Test
    public void testDueDate() {
        assertTrue(loan.getDueDate().equals(LocalDate.now().plusDays(14)));
    }

    //VG
    @Test
    void newLoanShouldBeCurrent() {
        assertTrue(loan.getStatus().equals(LoanStatus.CURRENT));
    }

    //VG
    @Test
    void endLoanShouldBeHistoric() {
        loan.endLoan();
        assertTrue(loan.getStatus().equals(LoanStatus.HISTORIC));
    }
}