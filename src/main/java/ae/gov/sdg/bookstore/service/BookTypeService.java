package ae.gov.sdg.bookstore.service;

import java.util.List;

import ae.gov.sdg.bookstore.dto.BookTypeDTO;


/**
 * The Interface BookTypeService.
 * 
 * @author Adeel.Ahmad
 */
public interface BookTypeService {

	/**
	 * Find all book types.
	 *
	 * @return the list
	 */
	List<BookTypeDTO> findAllBookTypes();

}
