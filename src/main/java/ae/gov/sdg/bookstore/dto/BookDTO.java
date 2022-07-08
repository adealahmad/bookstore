package ae.gov.sdg.bookstore.dto;

import java.io.Serializable;

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
public class BookDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1900109148529424082L;

	/** The book id. */
	private Long bookId;

	/** The name. */
	private String name;

	/** The author. */
	private String author;

	/** The isbn. */
	private String isbn;

	/** The price. */
	private Double price;

	/** The description. */
	private String description;

	/** The book type id. */
	private Long bookTypeId;

}
