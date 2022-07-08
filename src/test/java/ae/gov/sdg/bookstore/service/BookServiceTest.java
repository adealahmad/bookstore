package ae.gov.sdg.bookstore.service;

import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import ae.gov.sdg.bookstore.domain.Book;
import ae.gov.sdg.bookstore.domain.BookType;
import ae.gov.sdg.bookstore.dto.BookDTO;
import ae.gov.sdg.bookstore.repository.BookRepository;
import ae.gov.sdg.bookstore.repository.BookTypeRepository;


/**
 * The Class BookServiceTest.
 * 
 * @author Adeel.Ahmad
 */
@SpringBootTest
class BookServiceTest {

	/** The book service. */
	@Autowired
	private BookService bookService;

	/** The book repository. */
	@MockBean
	private BookRepository bookRepository;

	/** The book type repository. */
	@MockBean
	private BookTypeRepository bookTypeRepository;

	/**
	 * Test get all books.
	 */
	@Test
	void testGetAllBooks() {

		BookType bookType1 = new BookType(1L, "CODE 1", "Book Type 1", null, null);

		BookType bookType2 = new BookType(2L, "CODE 2", "Book Type 2", null, null);

		Book book1 = new Book(1l, "Book1", "Book1 Description", "Adeel.Ahmad", bookType1, 50.50, "ISBN1");
		Book book2 = new Book(2l, "Book2", "Book2 Description", "Adeel.Ahmad", bookType2, 100.50, "ISBN2");

		List<Book> books = new ArrayList<Book>(Arrays.asList(book1, book2));

		doReturn(books).when(bookRepository).findAll();

		List<BookDTO> bookVOs = bookService.findAllBooks();

		Assertions.assertNotNull(bookVOs, "Books should not be NULL");
		Assertions.assertTrue(!bookVOs.isEmpty(), "Books should not be Empty");
		Assertions.assertTrue(bookVOs.size() == 2, "Books size not correct");
	}

	/**
	 * Test get book by id.
	 */
	@Test
	void testGetBookById() {
		BookType bookType1 = new BookType(1L, "CODE 1", "Book Type 1", null, null);
		Book book1 = new Book(1l, "Book1", "Book1 Description", "Adeel.Ahmad", bookType1, 50.50, "ISBN1");

		Optional<Book> bookOpt = Optional.of(book1);

		doReturn(bookOpt).when(bookRepository).findById(Mockito.anyLong());

		BookDTO bookDTO = bookService.getBookById(Mockito.anyLong());

		Assertions.assertNotNull(bookDTO, "Book should not be NULL");
		Assertions.assertTrue(bookDTO.getName().equals("Book1"), "Discounts size not correct");
	}

	/**
	 * Test get book by name.
	 */
	@Test
	void testGetBookByName() {
		BookType bookType1 = new BookType(1L, "CODE 1", "Book Type 1", null, null);
		Book book1 = new Book(1l, "Book1", "Book1 Description", "Adeel.Ahmad", bookType1, 50.50, "ISBN1");

		doReturn(book1).when(bookRepository).findByNameIgnoreCase(Mockito.anyString());

		BookDTO bookVO = bookService.getBookByName(Mockito.anyString());

		Assertions.assertNotNull(bookVO, "Book should not be NULL");
		Assertions.assertTrue(bookVO.getName().equals("Book1"), "Discounts size not correct");
	}

	/**
	 * Test create book.
	 */
	@Test
	void testCreateBook() {
		BookType bookType1 = new BookType(1L, "CODE 1", "Book Type 1", null, null);
		doReturn(bookType1).when(bookTypeRepository).getById(Mockito.anyLong());

		Book book1 = new Book(1l, "Book1", "Book1 Description", "Adeel.Ahmad", bookType1, 50.50, "ISBN1");
		doReturn(book1).when(bookRepository).save(Mockito.any());

		BookDTO returnBook = bookService
				.saveBook(new BookDTO(1l, "Book 1", "Author 1", "ISBN-1", 100.00, "Book 1 Description", 1l));

		Assertions.assertNotNull(returnBook, "Book should not be NULL");
	}

	/**
	 * Test update book.
	 */
	@Test
	void testUpdateBook() {
		BookType bookType1 = new BookType(1L, "CODE 1", "Book Type 1", null, null);
		doReturn(bookType1).when(bookTypeRepository).getById(Mockito.anyLong());

		Book book1 = new Book(1l, "Book1", "Book1 Description", "Adeel.Ahmad", bookType1, 50.50, "ISBN1");
		doReturn(book1).when(bookRepository).getById(Mockito.anyLong());
		doReturn(book1).when(bookRepository).save(Mockito.any());

		BookDTO returnBook = bookService
				.updateBook(new BookDTO(1l, "Book 1", "Author 1", "ISBN-1", 100.00, "Book 1 Description", 1l));

		Assertions.assertNotNull(returnBook, "Book should not be NULL");
	}

	/**
	 * Test delete book.
	 */
	@Test
	void testDeleteBook() {
		BookType bookType1 = new BookType(1L, "CODE 1", "Book Type 1", null, null);
		Book book1 = new Book(1l, "Book1", "Book1 Description", "Adeel.Ahmad", bookType1, 50.50, "ISBN1");

		Optional<Book> bookOpt = Optional.of(book1);

		doReturn(bookOpt).when(bookRepository).findById(Mockito.anyLong());

		bookService.deleteBook(Mockito.anyLong());
	}

}
