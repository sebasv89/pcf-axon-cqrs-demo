package io.pivotal.catalog.commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class EditProductInCatalogCommand {

	@TargetAggregateIdentifier
	private final String id;

	private final String name;

	public EditProductInCatalogCommand(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "EditProductInCatalogCommand{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
	}
}
