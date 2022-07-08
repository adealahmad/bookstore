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
@Table(name = "books")
@AllArgsConstructor
public class Book implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1900109148529424082L;

	/** The book id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private Long bookId;

	/** The name. */
	@Column(name = "name")
	private String name;

	/** The description. */
	@Column(name = "description", columnDefinition = "text")
	private String description;

	/** The author. */
	@Column(name = "author")
	private String author;

	/** The book type. */
	@ManyToOne
	@JoinColumn(name = "book_type_id")
	private BookType bookType;

	/** The book price. */
	@Column(name = "price", precision = 10, scale = 2)
	private Double bookPrice;

	/** The isbn. */
	@Column(name = "isbn")
	private String isbn;

	/**
	 * Instantiates a new book.
	 *
	 * @param name the name
	 * @param author the author
	 * @param isbn the isbn
	 * @param price the price
	 * @param description the description
	 * @param bookType the book type
	 */
	public Book(String name, String author, String isbn, double price, String description,
			BookType bookType) {
		this.name = name;
		this.author = author;
		this.isbn = isbn;
		this.bookPrice = price;
		this.description = description;
		this.bookType = bookType;
	}

}
