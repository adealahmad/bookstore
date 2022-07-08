package ae.gov.sdg.bookstore.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import ae.gov.sdg.bookstore.dto.DiscountDTO;
import ae.gov.sdg.bookstore.service.DiscountService;


/**
 * The Class DiscountControllerTest.
 * 
 * @author Adeel.Ahmad
 */
@WebMvcTest(DiscountController.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class DiscountControllerTest {

	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;

	/** The mapper. */
	@Autowired
	private ObjectMapper mapper;

	/** The discount service. */
	@MockBean
	private DiscountService discountService;

	/**
	 * Test find all discounts.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testFindAllDiscounts() throws Exception {
		DiscountDTO discount1 = new DiscountDTO(1l, 25, 1L, 1L);
		DiscountDTO discount2 = new DiscountDTO(2l, 25, 2L, 2L);
		List<DiscountDTO> discounts = Arrays.asList(discount1, discount2);
		
		Mockito.when(discountService.getAllDiscounts()).thenReturn(discounts);
		
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/discounts/")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(2)));
	}

	/**
	 * Test find all discounts empty.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testFindAllDiscounts_Empty() throws Exception {
		List<DiscountDTO> discounts = new ArrayList<DiscountDTO>();

		Mockito.when(discountService.getAllDiscounts()).thenReturn(discounts);

		mockMvc.perform(MockMvcRequestBuilders.get("/discounts/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

	/**
	 * Test create discount success.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testCreateDiscount_Success() throws Exception {
		DiscountDTO discount1 = new DiscountDTO(50, 1L, 1L);
		Mockito.when(discountService.getDiscountByBookTypeAndPromoId(Mockito.anyLong(), Mockito.anyLong()))
				.thenReturn(null);
		Mockito.when(discountService.saveDiscount(Mockito.any())).thenReturn(discount1);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/discounts/")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(discount1));

		mockMvc.perform(mockRequest).andExpect(status().isCreated());
	}

	/**
	 * Test create discount already exists.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testCreateDiscount_AlreadyExists() throws Exception {
		DiscountDTO discount1 = new DiscountDTO(1l, 25, 1L, 1L);
		Mockito.when(discountService.getDiscountByBookTypeAndPromoId(Mockito.anyLong(), Mockito.anyLong()))
				.thenReturn(discount1);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/discounts/")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(discount1));

		mockMvc.perform(mockRequest).andExpect(status().isForbidden());
	}

}
