package ae.gov.sdg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ae.gov.sdg.bookstore.domain.BookType;

/**
 * The Interface BookTypeRepository.
 * 
 * @author Adeel.Ahmad
 */
@Repository
public interface BookTypeRepository extends JpaRepository<BookType, Long> {

}
