package ae.gov.sdg.bookstore.exception;


/**
 * The Class BookTypeNotFoundException.
 * 
 * @author Adeel.Ahmad
 */
public class BookTypeNotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8993780851860765040L;

	/**
	 * Instantiates a new book type not found exception.
	 *
	 * @param typeId the type id
	 */
	public BookTypeNotFoundException(Long typeId) {
		super("Book Type [id="+typeId+"] not found.");
	}

}
