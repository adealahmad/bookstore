package ae.gov.sdg.bookstore.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ae.gov.sdg.bookstore.domain.Book;
import ae.gov.sdg.bookstore.dto.BookDTO;

/**
 * The Class BookMapper.
 * 
 * @author Adeel.Ahmad
 */
@Component
public class BookMapper {

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Convert to entity.
	 *
	 * @param bookDTO the book DTO
	 * @return the book
	 */
	public Book convertToEntity(BookDTO bookDTO) {
		return modelMapper.map(bookDTO, Book.class);

	}

	/**
	 * Convert to dto.
	 *
	 * @param book the book
	 * @return the book DTO
	 */
	public BookDTO convertToDto(Book book) {
		return modelMapper.map(book, BookDTO.class);

	}

	/**
	 * Convert books.
	 *
	 * @param books the books
	 * @return the list
	 */
	public List<BookDTO> convertBooks(List<Book> books) {
		return books.stream().map(this::convertToDto).collect(Collectors.toList());

	}

}
