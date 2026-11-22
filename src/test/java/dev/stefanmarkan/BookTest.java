package dev.stefanmarkan;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dev.stefanmarkan.models.Book;
import org.junit.jupiter.api.Test;

class BookTest {

	//G
	@Test
	public void test2EqualBooks() {
		var book1 = new Book(1, "Learning Java", "", "", "", 0);
		var book2 = new Book(1, "Learning Java", "", "", "", 0);
        assertTrue(book1.equals(book2));
	}

	//G
	@Test
	public void test2NonEqualBooks() {
		var book1 = new Book(1, "Learning Java", "", "", "", 0);
        var book2 = new Book(2, "Understanding the Digital World", "", "", "", 1);
		assertFalse(book1.equals(book2));
	}

	//G
	@Test
	void booksWithSameIdAndTitleShouldBeEqual() {
		var book1 = new Book(1, "Learning Java", "Smith", "123", "", 200);
		var book2 = new Book(1, "Learning Java", "Doe", "456", "", 20);
		assertTrue(book1.equals(book2));
	}

	//G
	@Test
	void booksWithDifferentIdsShouldNotBeEqual() {
		var book1 = new Book(1, "Learning Java", "", "", "", 0);
		var book2 = new Book(2, "Learning Java", "", "", "", 0);
        assertFalse(book1.equals(book2));
	}


	//G
	@Test
	void booksWithSameIdButDifferentTitlesShouldNotBeEqual() {
		var book1 = new Book(1, "Learning Java", "", "", "", 0);
		var book2 = new Book(1, "Understanding the Digital World", "", "", "", 0);
		assertFalse(book1.equals(book2));
	}
}
