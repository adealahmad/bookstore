package ae.gov.sdg.bookstore.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import ae.gov.sdg.bookstore.dto.BookTypeDTO;
import ae.gov.sdg.bookstore.service.BookTypeService;


/**
 * The Class BookTypeControllerTest.
 * 
 * @author Adeel.Ahmad
 */
@WebMvcTest(BookTypeController.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class BookTypeControllerTest {
	
    /** The mock mvc. */
    @Autowired
    private MockMvc mockMvc;

    /** The book type repository. */
    @MockBean
    private BookTypeService bookTypeService;
    
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		BookTypeDTO bootTypeDTO1 = new BookTypeDTO(1L, "TypeCode 1", "Book 1");
		BookTypeDTO bootTypeDTO2 = new BookTypeDTO(2L, "TypeCode 2", "Book 2");
		

		List<BookTypeDTO> bookTypes = new ArrayList<>(Arrays.asList(bootTypeDTO1, bootTypeDTO2));
		
		Mockito.when(bookTypeService.findAllBookTypes()).thenReturn(bookTypes);
	}

	/**
	 * Test find all book types.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testFindAllBookTypes() throws Exception {
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/bookTypes/")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(2)))
	            .andExpect(jsonPath("$[0].displayName", is("Book 1")));
	}
	
}
