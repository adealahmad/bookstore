package ae.gov.sdg.bookstore.exception;


/**
 * The Class BookAlreadyExistsException.
 * 
 * @author Adeel.Ahmad
 */
public class BookAlreadyExistsException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2914352932353103061L;

	/**
	 * Instantiates a new book already exists exception.
	 *
	 * @param bookName the book name
	 */
	public BookAlreadyExistsException(String bookName) {
		super("Book [name="+bookName+"] already exists.");
	}

}
