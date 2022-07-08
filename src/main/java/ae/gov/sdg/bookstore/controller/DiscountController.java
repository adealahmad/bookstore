package ae.gov.sdg.bookstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ae.gov.sdg.bookstore.dto.DiscountDTO;
import ae.gov.sdg.bookstore.exception.DiscountAlreadyExistsException;
import ae.gov.sdg.bookstore.service.DiscountService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

/**
 * REST controller for managing Book.
 * 
 * @author Adeel.Ahmad
 */

@Slf4j
@RestController
@RequestMapping("/discounts")
public class DiscountController {

	/** The discount service. */
	private DiscountService discountService;

	/**
	 * Instantiates a new discount controller.
	 *
	 * @param discountService the discount service
	 */
	public DiscountController(DiscountService discountService) {
		this.discountService = discountService;
	}

	/**
	 * POST /discounts : Create a new discount.
	 *
	 * @param discount the discount
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         promotions, or with status 400 (Bad Request) if the promotions has
	 *         already an ID
	 */
	@Operation(summary = "Create Discount")
	@PostMapping
	public ResponseEntity<DiscountDTO> createDiscount(@RequestBody DiscountDTO discount) {

		log.info("DiscountController:createPromotion()...");
		if (discountService.getDiscountByBookTypeAndPromoId(discount.getBookTypeId(),
				discount.getPromoId()) != null) {
			log.warn("Discount already exists.");
			throw new DiscountAlreadyExistsException(discount.getBookTypeId(), discount.getPromoId());
		}

		if (discount.getDiscountId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		DiscountDTO resultDiscount = discountService.saveDiscount(discount);
		return new ResponseEntity<>(resultDiscount, HttpStatus.CREATED);
	}

	/**
	 * GET /discounts : get all the discounts.
	 *
	 * @return the ResponseEntity with status 200 (OK) and the list of discounts in
	 *         body, or with status 204 (NO CONTENT) if there no discounts in
	 *         repository
	 */
	@Operation(summary = "Get All Discounts")
	@GetMapping
	public ResponseEntity<List<DiscountDTO>> getAllDiscounts() {
		List<DiscountDTO> discounts = discountService.getAllDiscounts();
		if (discounts.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(discounts, HttpStatus.OK);
	}

}