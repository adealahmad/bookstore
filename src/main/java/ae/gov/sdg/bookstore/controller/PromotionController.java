package ae.gov.sdg.bookstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ae.gov.sdg.bookstore.dto.PromotionDTO;
import ae.gov.sdg.bookstore.exception.PromotionAlreadyExistsException;
import ae.gov.sdg.bookstore.service.PromotionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

/**
 * REST controller for managing Book.
 * 
 * @author Adeel.Ahmad
 */

@Slf4j
@RestController
@RequestMapping("/promotions")
public class PromotionController {

	/** The promotion service. */
	private PromotionService promotionService;

	/**
	 * Instantiates a new promotion controller.
	 *
	 * @param promotionService the promotion service
	 */
	public PromotionController(PromotionService promotionService) {
		this.promotionService = promotionService;
	}

	/**
	 * POST /promotions : Create a new book.
	 *
	 * @param promotionDTO the book to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         promotions, or with status 400 (Bad Request) if the promotions has
	 *         already an ID
	 */
	@Operation(summary = "Create Promotion")
	@PostMapping
	public ResponseEntity<PromotionDTO> createPromotion(@RequestBody PromotionDTO promotionDTO) {
		log.info("PromotionController:createPromotion()...");
		if (promotionService.getPromotionByCode(promotionDTO.getPromoCode()) != null) {
			log.warn("Promotion already exists.");
			throw new PromotionAlreadyExistsException(promotionDTO.getPromoCode());
		}
		promotionDTO = promotionService.savePromotion(promotionDTO);
		return new ResponseEntity<>(promotionDTO, HttpStatus.CREATED);
	}

	/**
	 * GET /promotions : get all the promotions.
	 *
	 * @return the ResponseEntity with status 200 (OK) and the list of promotions in
	 *         body, or with status 204 (NO CONTENT) if there no promotions in
	 *         repository
	 */
	@Operation(summary = "Get All Promotions")
	@GetMapping
	public ResponseEntity<List<PromotionDTO>> getAllPromotions() {
		List<PromotionDTO> promotions = promotionService.findAllPromotions();
		if (promotions.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(promotions, HttpStatus.OK);
	}

}