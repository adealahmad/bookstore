package ae.gov.sdg.bookstore.exception;


/**
 * The Class PromotionNotFoundException.
 * 
 * @author Adeel.Ahmad
 */
public class PromotionNotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7981236738034613250L;

	/**
	 * Instantiates a new promotion not found exception.
	 *
	 * @param promoCode the promo code
	 */
	public PromotionNotFoundException(String promoCode) {
		super("Promotion [code="+promoCode+"] not found.");
	}
	
	/**
	 * Instantiates a new promotion not found exception.
	 *
	 * @param promoId the promo id
	 */
	public PromotionNotFoundException(Long promoId) {
		super("Promotion [id="+promoId+"] not found.");
	}

}
