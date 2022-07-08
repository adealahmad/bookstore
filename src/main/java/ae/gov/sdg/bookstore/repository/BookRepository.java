package ae.gov.sdg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ae.gov.sdg.bookstore.domain.Book;


/**
 * The Interface BookRepository.
 * 
 * @author Adeel.Ahmad
 */
public interface BookRepository extends JpaRepository<Book, Long> {

	/**
	 * Find by book id.
	 *
	 * @param bookId the book id
	 * @return the book
	 */
	Book findByBookId(Long bookId);

	/**
	 * Find by name ignore case.
	 *
	 * @param name the name
	 * @return the book
	 */
	Book findByNameIgnoreCase(String name);

}
