package com.client.bu.project.cachedomain.servicedescriptor;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "kind", "itemType" })
public class CollectionType extends Type {
	private Type itemType;

	public CollectionType(Type itemType) {
		super();
		this.itemType = itemType;
	}

	public CollectionType() {
	}

	public Type getItemType() {
		return itemType;
	}

	public void setItemType(Type itemType) {
		this.itemType = itemType;
	}

	@Override
	public java.lang.String getKind() {
		return "Collection";
	}
}
