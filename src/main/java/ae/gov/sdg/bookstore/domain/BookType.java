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
@Table(name = "book_types")
@AllArgsConstructor
public class BookType implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3446491477451552684L;

	/** The book type id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_type_id")
	private Long bookTypeId;

	/** The type code. */
	@Column(name = "type_code")
	private String typeCode;

	/** The display name. */
	@Column(name = "display_name")
	private String displayName;

	/** The discounts. */
	@OneToMany(mappedBy = "bookType")
	private Set<Discount> discounts;

	/** The books. */
	@OneToMany(mappedBy = "bookType")
	private Set<Book> books;

}
