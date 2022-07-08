package ae.gov.sdg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ae.gov.sdg.bookstore.domain.Discount;


/**
 * The Interface DiscountRepository.
 * 
 * @author Adeel.Ahmad
 */
@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {

	
	/**
	 * Find by discount id.
	 *
	 * @param discountId the discount id
	 * @return the discount
	 */
	Discount findByDiscountId(Long discountId);
	
	/**
	 * Find by book type and promo id.
	 *
	 * @param bookTypeId the book type id
	 * @param promoId the promo id
	 * @return the discount
	 */
	@Query("SELECT dis from Discount dis WHERE dis.bookType.bookTypeId = :bookTypeId AND dis.promotion.promoId = :promoId")
	Discount findByBookTypeAndPromoId(
			@Param("bookTypeId") Long bookTypeId,
			@Param("promoId") Long promoId);
	
	/**
	 * Find by book type and promo code.
	 *
	 * @param bookTypeId the book type id
	 * @param promoCode the promo code
	 * @return the discount
	 */
	@Query("SELECT dis from Discount dis WHERE dis.bookType.bookTypeId = :bookTypeId AND dis.promotion.promoCode = :promoCode")
	Discount findByBookTypeAndPromoCode(
			@Param("bookTypeId") Long bookTypeId,
			@Param("promoCode") String promoCode);

}
