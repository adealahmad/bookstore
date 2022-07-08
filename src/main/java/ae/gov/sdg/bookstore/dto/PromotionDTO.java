package ae.gov.sdg.bookstore.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

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
public class PromotionDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3377852153505771264L;

	/** The promo id. */
	private Long promoId;
	
    /** The promo code. */
    @NotBlank
	private String promoCode;

	/** The name. */
	private String name;
	
	/** The description. */
	private String description;

}
