package ae.gov.sdg.bookstore.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ae.gov.sdg.bookstore.domain.Promotion;
import ae.gov.sdg.bookstore.dto.PromotionDTO;
import ae.gov.sdg.bookstore.mapper.PromotionMapper;
import ae.gov.sdg.bookstore.repository.PromotionRepository;
import ae.gov.sdg.bookstore.service.PromotionService;
import lombok.extern.slf4j.Slf4j;


/**
 * The Class Promotion Service Implementation.
 * 
 * @author Adeel.Ahmad
 *
 */
@Slf4j
@Service
public class PromotionServiceImpl implements PromotionService {

	/** The promotion repository. */
	private final PromotionRepository promotionRepository;

	/** The promotion mapper. */
	private final PromotionMapper promotionMapper;

	/**
	 * Instantiates a new promotion service impl.
	 *
	 * @param promotionRepository the promotion repository
	 * @param promotionMapper the promotion mapper
	 */
	public PromotionServiceImpl(PromotionRepository promotionRepository, PromotionMapper promotionMapper) {
		this.promotionRepository = promotionRepository;
		this.promotionMapper = promotionMapper;
	}

	/**
	 * Find all promotions.
	 *
	 * @return the list
	 */
	@Override
	public List<PromotionDTO> findAllPromotions() {
		List<Promotion> promotions = promotionRepository.findAll();

		return promotionMapper.convertPromotions(promotions);
	}

	/**
	 * Save promotion.
	 *
	 * @param promotionDTO the promotion DTO
	 * @return the promotion DTO
	 */
	@Override
	public PromotionDTO savePromotion(PromotionDTO promotionDTO) {
		Promotion promotion = promotionMapper.convertToEntity(promotionDTO);
		promotion = promotionRepository.save(promotion);
		return promotionMapper.convertToDto(promotion);
	}

	/**
	 * Gets the promotion by code.
	 *
	 * @param promoCode the promo code
	 * @return the promotion by code
	 */
	@Override
	public PromotionDTO getPromotionByCode(String promoCode) {
		log.info("BookService:getPromotionByCode("+promoCode+")...");
		Promotion promotion = promotionRepository.findByPromoCodeIgnoreCase(promoCode);
		if( promotion != null ) {
			return promotionMapper.convertToDto(promotion);
		}
		return null;
	}

}
