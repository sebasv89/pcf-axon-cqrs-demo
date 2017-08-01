package io.pivotal.catalog.controllers;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.catalog.commands.AddProductToCatalogCommand;
import io.pivotal.catalog.commands.EditProductInCatalogCommand;
import io.pivotal.catalog.services.CatalogService;

@RestController
public class CatalogApiController {

	private static final Logger LOG = LoggerFactory.getLogger(CatalogApiController.class);

	private final CatalogService catalogService;

	public CatalogApiController(CatalogService commandGateway) {
		this.catalogService = commandGateway;
	}

	@PostMapping("/add")
	public CompletableFuture<String> addProductToCatalog(@RequestBody Map<String, String> request) {

		AddProductToCatalogCommand command = new AddProductToCatalogCommand(request.get("id"), request.get("name"));
		LOG.info("Executing command: {}", command);
		return catalogService.addProductToCatalog(command);
	}

	@PostMapping("/edit")
	public CompletableFuture<String> editProductInCatalog(@RequestBody Map<String, String> request) {

		EditProductInCatalogCommand command = new EditProductInCatalogCommand(request.get("id"), request.get("name"));
		LOG.info("Executing command: {}", command);
		return catalogService.editProductInCatalog(command);

	}
}
