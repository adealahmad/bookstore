package ae.gov.sdg.bookstore.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ae.gov.sdg.bookstore.domain.Discount;
import ae.gov.sdg.bookstore.dto.DiscountDTO;
import ae.gov.sdg.bookstore.mapper.DiscountMapper;
import ae.gov.sdg.bookstore.repository.DiscountRepository;
import ae.gov.sdg.bookstore.repository.PromotionRepository;
import ae.gov.sdg.bookstore.service.DiscountService;
import lombok.extern.slf4j.Slf4j;


/**
 * The Class Discount Service Implementation.
 * 
 * @author Adeel.Ahmad
 */
@Slf4j
@Service
public class DiscountServiceImpl implements DiscountService {

	/** The discount repository. */
	private final DiscountRepository discountRepository;

	/** The discount mapper. */
	private final DiscountMapper discountMapper;

	/**
	 * Instantiates a new discount service impl.
	 *
	 * @param discountRepository the discount repository
	 * @param promotionRepository the promotion repository
	 * @param promotionMapper the promotion mapper
	 */
	public DiscountServiceImpl(DiscountRepository discountRepository, PromotionRepository promotionRepository,
			DiscountMapper promotionMapper) {
		this.discountRepository = discountRepository;
		this.discountMapper = promotionMapper;
	}

	/**
	 * Gets the all discounts.
	 *
	 * @return the all discounts
	 */
	@Override
	public List<DiscountDTO> getAllDiscounts() {
		List<Discount> discounts = discountRepository.findAll();

		return discountMapper.convertDiscounts(discounts);
	}

	/**
	 * Save discount.
	 *
	 * @param discountDTO the discount DTO
	 * @return the discount DTO
	 */
	@Override
	public DiscountDTO saveDiscount(DiscountDTO discountDTO) {
		Discount discount = discountMapper.convertToEntity(discountDTO);
		discount = discountRepository.save(discount);
		return discountMapper.convertToDto(discount);
	}
	
	/**
	 * Gets the discount by book type and promo code.
	 *
	 * @param bookType the book type
	 * @param promoCode the promo code
	 * @return the discount by book type and promo code
	 */
	@Override
	public DiscountDTO getDiscountByBookTypeAndPromoCode(Long bookType, String promoCode) {
		log.info("DiscountServiceImpl.getDiscountByBookTypeAndPromoCode(bookType="+bookType+", promoCode="+promoCode+")...");
		DiscountDTO discountDTO = null;
		Discount discount = discountRepository.findByBookTypeAndPromoCode(bookType, promoCode);
		if(discount != null) {
			discountDTO = discountMapper.convertToDto(discount);
		}
		return discountDTO;
	}
	
	/**
	 * Gets the discount by book type and promo id.
	 *
	 * @param bookTypeId the book type id
	 * @param promoId the promo id
	 * @return the discount by book type and promo id
	 */
	@Override
	public DiscountDTO getDiscountByBookTypeAndPromoId(Long bookTypeId, Long promoId) {
		log.info("DiscountServiceImpl.getDiscountByBookTypeAndPromoId(bookTypeId="+bookTypeId+", promoId="+promoId+")...");
		DiscountDTO discountDTO = null;
		Discount discount = discountRepository.findByBookTypeAndPromoId(bookTypeId, promoId);
		if(discount != null) {
			discountDTO = discountMapper.convertToDto(discount);
		}
		return discountDTO;
	}

}
