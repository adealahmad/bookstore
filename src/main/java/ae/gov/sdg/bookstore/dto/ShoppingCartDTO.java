package ae.gov.sdg.bookstore.dto;

import java.io.Serializable;
import java.util.List;

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
public class ShoppingCartDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -310696326093732965L;

	/** The book Ids. */
	private List<Long> bookIDs;

	/** The promo code. */
	private String promoCode;


}