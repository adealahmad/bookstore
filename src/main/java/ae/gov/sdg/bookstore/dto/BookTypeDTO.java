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
public class BookTypeDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1900109148529424082L;

	/** The book type id. */
	private Long bookTypeId;

	/** The type code. */
	private String typeCode;

	/** The display name. */
	private String displayName;

}
