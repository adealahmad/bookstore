package ae.gov.sdg.bookstore.service;

import java.util.List;

import ae.gov.sdg.bookstore.dto.PromotionDTO;


/**
 * The Interface PromotionService.
 * 
 * @author Adeel.Ahmad
 */
public interface PromotionService {

	/**
	 * Find all promotions.
	 *
	 * @return the list
	 */
	List<PromotionDTO> findAllPromotions();

	/**
	 * Save promotion.
	 *
	 * @param promotionDTO the promotion DTO
	 * @return the promotion DTO
	 */
	PromotionDTO savePromotion(PromotionDTO promotionDTO);

	/**
	 * Gets the promotion by code.
	 *
	 * @param promoCode the promo code
	 * @return the promotion by code
	 */
	PromotionDTO getPromotionByCode(String promoCode);
}
