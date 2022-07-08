package ae.gov.sdg.bookstore.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ae.gov.sdg.bookstore.domain.Discount;
import ae.gov.sdg.bookstore.dto.DiscountDTO;


/**
 * The Class DiscountMapper.
 * 
 * @author Adeel.Ahmad
 */
@Component
public class DiscountMapper {
	
	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * Convert to entity.
	 *
	 * @param discountDTO the discount DTO
	 * @return the discount
	 */
	public Discount convertToEntity(DiscountDTO discountDTO) {
	    return modelMapper.map(discountDTO, Discount.class);
	}
	
	/**
	 * Convert to dto.
	 *
	 * @param discount the discount
	 * @return the discount DTO
	 */
	public DiscountDTO convertToDto(Discount discount) {
	    return modelMapper.map(discount, DiscountDTO.class);
	}
	
	/**
	 * Convert discounts.
	 *
	 * @param discount the discount
	 * @return the list
	 */
	public List<DiscountDTO> convertDiscounts(List<Discount> discount) {
	    return discount.stream().map(this::convertToDto).collect(Collectors.toList());
	}

}
