package ae.gov.sdg.bookstore.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ae.gov.sdg.bookstore.domain.Promotion;
import ae.gov.sdg.bookstore.dto.PromotionDTO;


/**
 * The Class PromotionMapper.
 * 
 * @author Adeel.Ahmad
 */
@Component
public class PromotionMapper {
	
	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * Convert to entity.
	 *
	 * @param promotionDTO the promotion DTO
	 * @return the promotion
	 */
	public Promotion convertToEntity(PromotionDTO promotionDTO) {
	    return modelMapper.map(promotionDTO, Promotion.class);
	}
	
	/**
	 * Convert to dto.
	 *
	 * @param promotion the promotion
	 * @return the promotion DTO
	 */
	public PromotionDTO convertToDto(Promotion promotion) {
	    return modelMapper.map(promotion, PromotionDTO.class);
	}
	
	/**
	 * Convert promotions.
	 *
	 * @param promotions the promotions
	 * @return the list
	 */
	public List<PromotionDTO> convertPromotions(List<Promotion> promotions) {
	    return promotions.stream().map(this::convertToDto).collect(Collectors.toList());
	}

}
