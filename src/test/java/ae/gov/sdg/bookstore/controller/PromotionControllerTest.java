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

import ae.gov.sdg.bookstore.dto.PromotionDTO;
import ae.gov.sdg.bookstore.service.PromotionService;


/**
 * The Class PromotionControllerTest.
 *
 * @author Adeel.Ahmad
 */
@WebMvcTest(PromotionController.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class PromotionControllerTest {

    /** The mock mvc. */
    @Autowired
    private MockMvc mockMvc;

    /** The mapper. */
    @Autowired
    private ObjectMapper mapper;

    /** The promotion service. */
    @MockBean
    private PromotionService promotionService;

	/**
	 * Test find all promotions.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testFindAllPromotions() throws Exception {
		PromotionDTO promotion1 = new PromotionDTO(1l, "Promo1", "Promo1", "Promo1");
		PromotionDTO promotion2 = new PromotionDTO(2l, "Promo2", "Promo2", "Promo2");
		List<PromotionDTO> promotions = Arrays.asList(promotion1, promotion2);

		Mockito.when(promotionService.findAllPromotions()).thenReturn(promotions);

	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/promotions/")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(2)));
	}

	/**
	 * Test find all promotions is empty.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testFindAllPromotions_IsEmpty() throws Exception {
		List<PromotionDTO> promotions = new ArrayList<PromotionDTO>();

		Mockito.when(promotionService.findAllPromotions()).thenReturn(promotions);

	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/promotions/")
	            .contentType(MediaType.APPLICATION_JSON))
	    		.andExpect(status().isNoContent());
	}

	/**
	 * Test create promotion.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testCreatePromotion() throws Exception {
		PromotionDTO promotion1 = new PromotionDTO(1l, "Promo1", "Promo1", "Promo1");
		Mockito.when(promotionService.getPromotionByCode(Mockito.anyString()))
				.thenReturn(null);
	    Mockito.when(promotionService.savePromotion(Mockito.any()))
	    		.thenReturn(promotion1);

	    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/promotions/")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.mapper.writeValueAsString(promotion1));

	    mockMvc.perform(mockRequest)
	            .andExpect(status().isCreated());
	}

	/**
	 * Test create promotion already exists.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testCreatePromotion_AlreadyExists() throws Exception {
		PromotionDTO promotion1 = new PromotionDTO(1l, "Promo1", "Promo1", "Promo1");
		Mockito.when(promotionService.getPromotionByCode(Mockito.anyString()))
				.thenReturn(promotion1);

	    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/promotions/")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.mapper.writeValueAsString(promotion1));

	    mockMvc.perform(mockRequest)
	    		.andExpect(status().isForbidden());
	}

}
