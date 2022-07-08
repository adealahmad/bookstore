package ae.gov.sdg.bookstore.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class DiscountDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7734898633223177954L;

	/** The discount id. */
	private Long discountId;

	@NotNull
	@Min(1)
	@Max(75)
	private Integer discountPercentage;

	@NotNull
	private Long bookTypeId;

	@NotNull
	private Long promoId;

	/**
	 * Instantiates a new discount DTO.
	 *
	 * @param discountPercentage the discount percentage
	 * @param bookTypeId the book type id
	 * @param promoId the promo id
	 */
	public DiscountDTO(Integer discountPercentage, Long bookTypeId, Long promoId) {
		super();
		this.discountPercentage = discountPercentage;
		this.bookTypeId = bookTypeId;
		this.promoId = promoId;
	}

}
