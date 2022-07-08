package ae.gov.sdg.bookstore.service;

import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import ae.gov.sdg.bookstore.domain.Discount;
import ae.gov.sdg.bookstore.domain.Promotion;
import ae.gov.sdg.bookstore.dto.DiscountDTO;
import ae.gov.sdg.bookstore.repository.DiscountRepository;
import ae.gov.sdg.bookstore.repository.PromotionRepository;


/**
 * The Class DiscountServiceTest.
 * 
 * @author Adeel.Ahmad
 */
@SpringBootTest
class DiscountServiceTest {

	/** The discount service. */
	@Autowired
	private DiscountService discountService;

	/** The discount repository. */
	@MockBean
	private DiscountRepository discountRepository;

	/** The promotion repository. */
	@MockBean
	private PromotionRepository promotionRepository;

	/**
	 * Test get all discounts.
	 */
	@Test
	void testGetAllDiscounts() {
		Discount discount1 = new Discount(1l, 25, null, 1L, null, 1L);
		Discount discount2 = new Discount(2l, 50, null, 2L, null, 2L);
		List<Discount> discounts = new ArrayList<Discount>(Arrays.asList(discount1, discount2));

		doReturn(discounts).when(discountRepository).findAll();

		List<DiscountDTO> discountDTOs = discountService.getAllDiscounts();

		Assertions.assertNotNull(discountDTOs, "Discounts should not be NULL");
		Assertions.assertTrue(!discountDTOs.isEmpty(), "Discounts should not be Empty");
		Assertions.assertTrue(discountDTOs.size() == 2, "Discounts size not correct");
	}

	/**
	 * Test create discount.
	 */
	@Test
	void testCreateDiscount() {
		Promotion promotion1 = new Promotion(1l, "Promo1", "Promo1", "Promo1");
		doReturn(promotion1).when(promotionRepository).findByPromoId(Mockito.anyLong());

		Discount discount1 = new Discount(1l, 25, 1L, 1L);
		doReturn(discount1).when(discountRepository).save(Mockito.any());

		DiscountDTO returnDiscount = discountService.saveDiscount(new DiscountDTO(1l, 25, 1L, 1L));

		Assertions.assertNotNull(returnDiscount, "Discount should not be NULL");
	}

	/**
	 * Test get discount by book type and promo code.
	 */
	@Test
	void testGetDiscountByBookTypeAndPromoCode() {
		Discount discount1 = new Discount(1l, 25, 1L, 1L);
		doReturn(discount1).when(discountRepository).findByBookTypeAndPromoCode(Mockito.anyLong(), Mockito.anyString());

		DiscountDTO returnDiscount = discountService.getDiscountByBookTypeAndPromoCode(Mockito.anyLong(),
				Mockito.anyString());

		Assertions.assertNotNull(returnDiscount, "Discount should not be NULL");
	}

	/**
	 * Test get discount by book type and promo id.
	 */
	@Test
	void testGetDiscountByBookTypeAndPromoId() {
		Discount discount1 = new Discount(1l, 25, 1L, 1L);
		doReturn(discount1).when(discountRepository).findByBookTypeAndPromoId(Mockito.anyLong(), Mockito.anyLong());

		DiscountDTO returnDiscount = discountService.getDiscountByBookTypeAndPromoId(Mockito.anyLong(),
				Mockito.anyLong());

		Assertions.assertNotNull(returnDiscount, "Discount should not be NULL");
	}

}
