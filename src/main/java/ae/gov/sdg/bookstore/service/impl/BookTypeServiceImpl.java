package ae.gov.sdg.bookstore.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ae.gov.sdg.bookstore.domain.BookType;
import ae.gov.sdg.bookstore.dto.BookTypeDTO;
import ae.gov.sdg.bookstore.mapper.BookTypeMapper;
import ae.gov.sdg.bookstore.repository.BookTypeRepository;
import ae.gov.sdg.bookstore.service.BookTypeService;


/**
 * The Class BookType Service Implementation.
 * 
 * @author Adeel.Ahmad
 */
@Service
public class BookTypeServiceImpl implements BookTypeService {

	/** The book type repository. */
	private final BookTypeRepository bookTypeRepository;

	/** The book type mapper. */
	private final BookTypeMapper bookTypeMapper;

	/**
	 * Instantiates a new book type service impl.
	 *
	 * @param bookTypeRepository the book type repository
	 * @param bookTypeMapper the book type mapper
	 */
	public BookTypeServiceImpl(BookTypeRepository bookTypeRepository, BookTypeMapper bookTypeMapper) {
		this.bookTypeRepository = bookTypeRepository;
		this.bookTypeMapper = bookTypeMapper;
	}

	/**
	 * Find all book types.
	 *
	 * @return the list
	 */
	@Override
	public List<BookTypeDTO> findAllBookTypes() {
		List<BookType> bookTypes = bookTypeRepository.findAll();

		return bookTypeMapper.convertBookTypes(bookTypes);
	}

}
