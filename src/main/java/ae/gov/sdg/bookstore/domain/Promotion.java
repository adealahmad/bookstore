package ae.gov.sdg.bookstore.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Entity
@Table(name = "promotions")
@AllArgsConstructor
public class Promotion implements Serializable{

	private static final long serialVersionUID = -5545457900271932134L;

	/** The promo id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "promo_id")
	private Long promoId;

	/** The promo code. */
	@Column(name = "promo_code")
	private String promoCode;

	/** The name. */
	@Column(name = "name")
	private String name;

	/** The description. */
	@Column(name = "description")
	private String description;

	/** The discounts. */
	@OneToMany(mappedBy = "promotion")
	private Set<Discount> discounts;

	/**
	 * Instantiates a new promotion.
	 *
	 * @param promoId the promo id
	 * @param promoCode the promo code
	 * @param name the name
	 * @param description the description
	 */
	public Promotion(Long promoId, String promoCode, String name, String description) {
		super();
		this.promoId = promoId;
		this.promoCode = promoCode;
		this.name = name;
		this.description = description;
	}

}
