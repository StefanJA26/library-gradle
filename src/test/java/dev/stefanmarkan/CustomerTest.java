package dev.stefanmarkan;

import dev.stefanmarkan.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dev.stefanmarkan.utilities.GenderType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    private Customer customer;

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
    }

    //G
    @Test
    void testGetGender() {
        assertEquals(GenderType.MALE, customer.getGender());
    }

    //G
    @Test
    void testGetMailingName() {
        assertEquals(String.format("Mr %s %s",
                        customer.getFirstName().charAt(0),
                        customer.getSurname()),
                customer.getMailingName());
    }
}
