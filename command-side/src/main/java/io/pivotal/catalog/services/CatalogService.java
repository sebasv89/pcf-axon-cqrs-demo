package io.pivotal.catalog.services;

import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.pivotal.catalog.commands.AddProductToCatalogCommand;
import io.pivotal.catalog.commands.EditProductInCatalogCommand;

@Service
public class CatalogService {

	private static final Logger LOG = LoggerFactory.getLogger(CatalogService.class);

	private final CommandGateway commandGateway;

	public CatalogService(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	public CompletableFuture<String> addProductToCatalog(AddProductToCatalogCommand command) {
		LOG.debug("Processing AddProductToCatalogCommand command: {}", command);
		return this.commandGateway.send(command);
	}

	public CompletableFuture<String> editProductInCatalog(EditProductInCatalogCommand command) {
		LOG.debug("Processing EditProductInCatalogCommand command: {}", command);
		return this.commandGateway.send(command);
	}
}
