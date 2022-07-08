package ae.gov.sdg.bookstore.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "discounts")
@AllArgsConstructor
public class Discount implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 38390894752370547L;

	/** The discount id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "discount_id")
	private Long discountId;

	/** The discount percentage. */
	@Column(name = "discount_percentage")
	private Integer discountPercentage;

	/** The book type. */
	@ManyToOne
	@JoinColumn(name = "book_type_id", insertable = false, updatable = false)
	private BookType bookType;

	/** The book type id. */
	@Column(name = "book_type_id")
	private Long bookTypeId;

	/** The promotion. */
	@ManyToOne
	@JoinColumn(name = "promo_id", insertable = false, updatable = false)
	private Promotion promotion;

	/** The promo id. */
	@Column(name = "promo_id")
	private Long promoId;

	/**
	 * Instantiates a new discount.
	 *
	 * @param discountId the discount id
	 * @param discountPercentage the discount percentage
	 * @param bookTypeId the book type id
	 * @param promoId the promo id
	 */
	public Discount(Long discountId, Integer discountPercentage, Long bookTypeId, Long promoId) {
		super();
		this.discountId = discountId;
		this.discountPercentage = discountPercentage;
		this.bookTypeId = bookTypeId;
		this.promoId = promoId;
	}
	
	

}
