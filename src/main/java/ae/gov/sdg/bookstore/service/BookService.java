package ae.gov.sdg.bookstore.service;

import java.util.List;
import java.util.Optional;

import ae.gov.sdg.bookstore.domain.Book;
import ae.gov.sdg.bookstore.dto.BookDTO;


/**
 * The Interface BookService.
 * 
 * @author Adeel.Ahmad
 */
public interface BookService {

	/**
	 * Find all books.
	 *
	 * @return the list
	 */
	List<BookDTO> findAllBooks();

	/**
	 * Find book by id.
	 *
	 * @param bookId the book id
	 * @return the optional
	 */
	Optional<Book> findBookById(Long bookId);

	/**
	 * Update book.
	 *
	 * @param bookDTO the book DTO
	 * @return the book DTO
	 */
	BookDTO updateBook(BookDTO bookDTO);

	/**
	 * Delete book.
	 *
	 * @param bookId the book id
	 */
	void deleteBook(Long bookId);

	/**
	 * Save book.
	 *
	 * @param bookDTO the book DTO
	 * @return the book DTO
	 */
	BookDTO saveBook(BookDTO bookDTO);

	/**
	 * Gets the book by id.
	 *
	 * @param bookId the book id
	 * @return the book by id
	 */
	BookDTO getBookById(Long bookId);

	/**
	 * Gets the book by name.
	 *
	 * @param anyString the any string
	 * @return the book by name
	 */
	BookDTO getBookByName(String anyString);

}
