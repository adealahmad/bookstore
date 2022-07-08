package ae.gov.sdg.bookstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ae.gov.sdg.bookstore.dto.BookTypeDTO;
import ae.gov.sdg.bookstore.service.BookTypeService;
import io.swagger.v3.oas.annotations.Operation;

/**
 * REST controller for managing Book Types.
 * 
 * @author Adeel.Ahmad
 * 
 */
@RestController
@RequestMapping("/bookTypes")
public class BookTypeController {

	/** The book type service. */
	private BookTypeService bookTypeService;

	/**
	 * Instantiates a new book type controller.
	 *
	 * @param bookTypeService the book type service
	 */
	public BookTypeController(BookTypeService bookTypeService) {
		this.bookTypeService = bookTypeService;
	}

	/**
	 * GET /books : get all the books.
	 *
	 * @return the ResponseEntity with status 200 (OK) and the list ob books in
	 *         body, or with status 204 (NO CONTENT) if there no books in repository
	 */
	@Operation(summary = "Get All Book Types")
	@GetMapping
	public ResponseEntity<List<BookTypeDTO>> getAllBookTypes() {
		List<BookTypeDTO> bookTypes = bookTypeService.findAllBookTypes();
		if (bookTypes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(bookTypes, HttpStatus.OK);
	}

}