package ae.gov.sdg.bookstore.service;

import java.util.List;

import ae.gov.sdg.bookstore.dto.DiscountDTO;


/**
 * The Interface DiscountService.
 * 
 * @author Adeel.Ahmad
 */
public interface DiscountService {

	/**
	 * Gets the all discounts.
	 *
	 * @return the all discounts
	 */
	List<DiscountDTO> getAllDiscounts();

	/**
	 * Save discount.
	 *
	 * @param discountDTO the discount DTO
	 * @return the discount DTO
	 */
	DiscountDTO saveDiscount(DiscountDTO discountDTO);

	/**
	 * Gets the discount by book type and promo code.
	 *
	 * @param bookType the book type
	 * @param promoCode the promo code
	 * @return the discount by book type and promo code
	 */
	DiscountDTO getDiscountByBookTypeAndPromoCode(Long bookType, String promoCode);

	/**
	 * Gets the discount by book type and promo id.
	 *
	 * @param bookTypeId the book type id
	 * @param promoId the promo id
	 * @return the discount by book type and promo id
	 */
	DiscountDTO getDiscountByBookTypeAndPromoId(Long bookTypeId, Long promoId);
}
