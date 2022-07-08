package ae.gov.sdg.bookstore.exception;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * The Class BookstoreExceptionHandler.
 * 
 * @author Adeel.Ahmad
 */
@RestControllerAdvice
public class BookstoreExceptionHandler {

    /**
     * Handle connversion.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(ConversionFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConnversion(RuntimeException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    /**
     * Handle book not found.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler({BookNotFoundException.class, BookTypeNotFoundException.class, PromotionNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleEntityNotFound(RuntimeException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    /**
     * Handle already exists.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler({BookAlreadyExistsException.class, PromotionAlreadyExistsException.class, DiscountAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<String> handleEntityAlreadyExists(RuntimeException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
    }
    
}
