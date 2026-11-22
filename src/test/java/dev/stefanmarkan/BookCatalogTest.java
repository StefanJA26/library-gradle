package dev.stefanmarkan;

import static org.junit.jupiter.api.Assertions.*;

import dev.stefanmarkan.models.Book;
import dev.stefanmarkan.models.BookCatalog;
import dev.stefanmarkan.models.BookNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.ValueSources;

public class BookCatalogTest {

    private BookCatalog bc;
    private Book book1;

    public BookCatalogTest() {
        bc = new BookCatalog();
        book1 = new Book(1, "Learning Java", "", "", "", 0);
        bc.addBook(book1);
    }

    //G
    @Test
    public void testAddABook() {
        assertSame(book1, bc.getBookArray()[0]);
    }

    //G
    @Test
    public void testFindBook() {
        assertSame(book1.getTitle(), bc.getBookArray()[0].getTitle());
    }

    //G
    @Test
    public void testFindBookIgnoringCase() {
        assertAll(
                () -> assertSame(bc.findBook(book1.getTitle().toUpperCase()), bc.findBook(book1.getTitle())),
                () -> assertSame(bc.findBook(book1.getTitle().toLowerCase()), bc.findBook(book1.getTitle())),
                () -> assertDoesNotThrow(() -> bc.findBook(book1.getTitle().toUpperCase())),
                () -> assertDoesNotThrow(() -> bc.findBook(book1.getTitle().toLowerCase()))
        );
    }

    //G
    @Test
    public void testFindBookWithExtraSpaces() {
        assertAll(
                () -> assertSame(bc.findBook(book1.getTitle()), bc.findBook("   " + book1.getTitle())),
                () -> assertSame(bc.findBook(book1.getTitle()), bc.findBook(book1.getTitle() + "   ")),
                () -> assertSame(bc.findBook(book1.getTitle()), bc.findBook("   " + book1.getTitle() + "   "))
        );
    }

    //G
    @Test
    public void shouldThrowExceptionWhenCatalogIsEmpty() {
        var emptyBc = new BookCatalog();
        assertThrows(BookNotFoundException.class, () -> emptyBc.findBook(book1.getTitle()));
    }

    //VG
    // This test should throw BookNotFoundException in order to pass.
    @Test
    public void testFindBookThatDoesntExist() throws BookNotFoundException {
        assertThrows(BookNotFoundException.class, () -> bc.findBook("Lord of the Rings"));
    }

    //VG
    //Skriv ett parameteriserat test som verifierar att metoden findBook(String title)
    // hittar samma bok oavsett hur titeln skrivs med stora och små bokstäver.
    //Du kan testa med
    // "Learning Java"
    //"learning java"
    //"LEARNING JAVA"
    @ParameterizedTest
    @ValueSource(strings = {
            "Learning Java",
            "learning java",
            "LEARNING JAVA",
            "LeArNiNg JaVa"
    })
    public void shouldFindBookRegardlessOfCase(String title) throws BookNotFoundException {
        assertSame(bc.findBook(title), bc.findBook(book1.getTitle()));
    }

}
