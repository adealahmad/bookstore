package ae.gov.sdg.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ae.gov.sdg.bookstore.dto.ShoppingCartDTO;
import ae.gov.sdg.bookstore.service.CheckoutService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;


/**
 * REST controller for managing Book.
 * 
 * @author Adeel.Ahmad
 */

@Slf4j
@RestController
@RequestMapping("/checkout")
public class CheckoutController {

	/** The checkout service. */
	private CheckoutService checkoutService;

	/**
	 * Instantiates a new checkout controller.
	 *
	 * @param checkoutService the checkout service
	 */
	public CheckoutController(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
	}

	/**
	 * Checkout.
	 *
	 * @param shoppingCartDTO the shopping cart DTO
	 * @return the response entity
	 */
	@Operation(summary = "Checkout Books Shopping Cart by applying Promo Code")
	@PostMapping
	public ResponseEntity<Double> checkout(@RequestBody ShoppingCartDTO shoppingCartDTO) {
		log.info("CheckoutController:checkout()...");
		Double totalPayable = checkoutService.checkout(shoppingCartDTO);
		return new ResponseEntity<>(totalPayable, HttpStatus.ACCEPTED);
	}

}