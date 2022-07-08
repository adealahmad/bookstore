package ae.gov.sdg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ae.gov.sdg.bookstore.domain.Promotion;


/**
 * The Interface PromotionRepository.
 * 
 * @author Adeel.Ahmad
 */
@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

	
	/**
	 * Find by promo id.
	 *
	 * @param promoId the promo id
	 * @return the book type
	 */
	Promotion findByPromoId(Long promoId);
	
	/**
	 * Find by promo code ignore case.
	 *
	 * @param promoCode the promo code
	 * @return the promotion
	 */
	Promotion findByPromoCodeIgnoreCase(String promoCode);


}
