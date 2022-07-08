package ae.gov.sdg.bookstore.service;

import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import ae.gov.sdg.bookstore.dto.BookDTO;
import ae.gov.sdg.bookstore.dto.DiscountDTO;
import ae.gov.sdg.bookstore.dto.ShoppingCartDTO;
import ae.gov.sdg.bookstore.exception.BookNotFoundException;


/**
 * The Class CheckoutServiceTest.
 * 
 * @author Adeel.Ahmad
 */
@SpringBootTest
class CheckoutServiceTest {
	
	/** The checkout service. */
	@Autowired
	private CheckoutService checkoutService;

    /** The book service. */
    @MockBean
	private BookService bookService;
	
    /** The discount service. */
    @MockBean
	private DiscountService discountService;

	/**
	 * Test checkout card.
	 */
	@Test
	void testCheckoutCard() {
		BookDTO book1 = new BookDTO(3l, "Book 3", "Author 3", "ISBN-3", 100.00, "Book 3 Description", 3l);
        doReturn(book1).when(bookService).getBookById(Mockito.anyLong());

        DiscountDTO discount1 = new DiscountDTO(1l, 25, 1L, 1L);
        doReturn(discount1).when(discountService).getDiscountByBookTypeAndPromoCode(
        		Mockito.anyLong(), Mockito.anyString());
        
        ArrayList<Long> bookIDs = new ArrayList<Long>(Arrays. asList(1l));
		ShoppingCartDTO cartDTO = checkoutService.checkout(
				new ShoppingCartDTO(bookIDs, "PROMO1", 0.0d));

		Assertions.assertNotNull(cartDTO, "ShoppingCartVO should not be NULL");
		Assertions.assertTrue(cartDTO.getTotalPayable() == 75.0d, "Total Payable is correct");
	}

	/**
	 * Test checkout card exception.
	 */
	@Test
	void testCheckoutCard_Exception() {
        doReturn(null).when(bookService).getBookById(Mockito.anyLong());

        ArrayList<Long> bookIDs = new ArrayList<Long>(Arrays. asList(1l));

	    RuntimeException rtException = Assertions.assertThrows(BookNotFoundException.class, () -> {
			checkoutService.checkout(new ShoppingCartDTO(bookIDs, "PROMO1", 0.0d));
	    });
	    
	    Assertions.assertEquals("Book [id=1] not found.", rtException.getMessage());
	}
}
