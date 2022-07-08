package ae.gov.sdg.bookstore.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ae.gov.sdg.bookstore.domain.Book;
import ae.gov.sdg.bookstore.dto.BookDTO;
import ae.gov.sdg.bookstore.exception.BookNotFoundException;
import ae.gov.sdg.bookstore.mapper.BookMapper;
import ae.gov.sdg.bookstore.repository.BookRepository;
import ae.gov.sdg.bookstore.service.BookService;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class Book Service Implementation.
 * 
 * @author Adeel.Ahmad
 *
 */

@Slf4j
@Service
public class BookServiceImpl implements BookService {

	/** The book repository. */
	private final BookRepository bookRepository;

	/** The book mapper. */
	private final BookMapper bookMapper;

	/**
	 * Instantiates a new book service impl.
	 *
	 * @param bookRepository the book repository
	 * @param bookMapper the book mapper
	 */
	public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
		this.bookRepository = bookRepository;
		this.bookMapper = bookMapper;
	}

	/**
	 * Find all books.
	 *
	 * @return the list
	 */
	@Override
	public List<BookDTO> findAllBooks() {
		List<Book> books = bookRepository.findAll();

		return bookMapper.convertBooks(books);
	}

	/**
	 * Gets the book by id.
	 *
	 * @param bookId the book id
	 * @return the book by id
	 */
	public BookDTO getBookById(Long bookId) {
		log.info("BookService:getBookById("+bookId+")...");
		Optional<Book> bookOpt = bookRepository.findById(bookId);
		if(bookOpt.isPresent())
			return bookMapper.convertToDto(bookOpt.get());
		return null;
	}

	/**
	 * Find book by id.
	 *
	 * @param bookId the book id
	 * @return the optional
	 */
	@Override
	public Optional<Book> findBookById(Long bookId) {
		return bookRepository.findById(bookId);
	}

	/**
	 * Update book.
	 *
	 * @param bookDTO the book DTO
	 * @return the book DTO
	 */
	@Override
	public BookDTO updateBook(BookDTO bookDTO) {

		Book exBook = bookRepository.getById(bookDTO.getBookId());
		if (exBook != null) {
			Book book = bookMapper.convertToEntity(bookDTO);
			book = bookRepository.save(book);
			return bookMapper.convertToDto(book);
		} else {
			throw new BookNotFoundException(bookDTO.getBookId());
		}
	}

	/**
	 * Delete book.
	 *
	 * @param bookId the book id
	 */
	@Override
	@Transactional
	public void deleteBook(Long bookId) {
		log.info("BookService:deleteBook(" + bookId + ")...");
		Optional<Book> bookOpt = bookRepository.findById(bookId);
		if (bookOpt.isPresent())
			bookRepository.delete(bookOpt.get());
		else {
			log.info("Book [id=" + bookId + "] not found!");
		}
		log.info("Book [id=" + bookId + "] deleted successfully!");
	}

	/**
	 * Save book.
	 *
	 * @param bookDTO the book DTO
	 * @return the book DTO
	 */
	@Override
	public BookDTO saveBook(BookDTO bookDTO) {
		Book book = bookMapper.convertToEntity(bookDTO);
		book = bookRepository.save(book);

		return bookMapper.convertToDto(book);
	}

	/**
	 * Gets the book by name.
	 *
	 * @param bookName the book name
	 * @return the book by name
	 */
	@Override
	public BookDTO getBookByName(String bookName) {
		log.info("BookService:getBookByName(" + bookName + ")...");
		Book book = bookRepository.findByNameIgnoreCase(bookName);
		if (book != null) {
			return bookMapper.convertToDto(book);
		}
		return null;
	}

}
