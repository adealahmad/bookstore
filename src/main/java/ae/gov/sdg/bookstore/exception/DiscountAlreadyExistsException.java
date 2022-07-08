package ae.gov.sdg.bookstore.exception;


/**
 * The Class DiscountAlreadyExistsException.
 * 
 * @author Adeel.Ahmad
 */
public class DiscountAlreadyExistsException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -307181129148221649L;

	/**
	 * Instantiates a new discount already exists exception.
	 *
	 * @param bookType the book type
	 * @param promoId the promo id
	 */
	public DiscountAlreadyExistsException(Long bookType, Long promoId) {
		super("Discount [promoId="+promoId+", bookType="+bookType+"] already exists.");
	}

}
