package ae.gov.sdg.bookstore.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ae.gov.sdg.bookstore.domain.BookType;
import ae.gov.sdg.bookstore.dto.BookTypeDTO;


/**
 * The Class BookTypeMapper.
 * 
 * @author Adeel.Ahmad
 */
@Component
public class BookTypeMapper {
	
	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * Convert to entity.
	 *
	 * @param bookTypeDTO the book type DTO
	 * @return the book type
	 */
	public BookType convertToEntity(BookTypeDTO bookTypeDTO) {
	    return modelMapper.map(bookTypeDTO, BookType.class);
	}
	
	/**
	 * Convert to dto.
	 *
	 * @param bookType the book type
	 * @return the book type DTO
	 */
	public BookTypeDTO convertToDto(BookType bookType) {
	    return modelMapper.map(bookType, BookTypeDTO.class);
	}
	
	/**
	 * Convert book types.
	 *
	 * @param bookTypes the book types
	 * @return the list
	 */
	public List<BookTypeDTO> convertBookTypes(List<BookType> bookTypes) {
	    return bookTypes.stream().map(this::convertToDto).collect(Collectors.toList());
	}

}
