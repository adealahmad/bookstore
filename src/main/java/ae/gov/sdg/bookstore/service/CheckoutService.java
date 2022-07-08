package ae.gov.sdg.bookstore.service;

import ae.gov.sdg.bookstore.dto.ShoppingCartDTO;


/**
 * The Interface CheckoutService.
 * 
 * @author Adeel.Ahmad
 */
public interface CheckoutService {

	/**
	 * Checkout card.
	 *
	 * @param shoppingCartDTO the shopping cart DTO
	 * @return the shopping cart VO
	 */
	Double checkout(ShoppingCartDTO shoppingCartDTO);
	
}