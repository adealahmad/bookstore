package ae.gov.sdg.bookstore.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

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

import ae.gov.sdg.bookstore.dto.ShoppingCartDTO;
import ae.gov.sdg.bookstore.service.CheckoutService;


/**
 * The Class CheckoutControllerTest.
 * 
 * @author Adeel.Ahmad
 */
@WebMvcTest(CheckoutController.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class CheckoutControllerTest {
	
    /** The mock mvc. */
    @Autowired
    private MockMvc mockMvc;
    
    /** The mapper. */
    @Autowired
    private ObjectMapper mapper;    

    /** The checkout service. */
    @MockBean
    private CheckoutService checkoutService;
    
	/**
	 * Test checkout cart.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testCheckoutCart() throws Exception {
		ArrayList<Long> bookIDs = new ArrayList<Long>(Arrays. asList(1l, 2l, 3l));
		ShoppingCartDTO cartVO = new ShoppingCartDTO(bookIDs, "PROMO1", 0.0d);
	    Mockito.when(checkoutService.checkout(Mockito.any())).thenReturn(cartVO);

	    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/checkout/")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.mapper.writeValueAsString(cartVO));

	    mockMvc.perform(mockRequest)
	            .andExpect(status().isAccepted())
		        .andExpect(jsonPath("$", notNullValue()))
	            .andExpect(jsonPath("$.promoCode", is("PROMO1")));
	}

}
