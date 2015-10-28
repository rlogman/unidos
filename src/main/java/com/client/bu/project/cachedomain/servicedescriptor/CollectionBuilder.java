package com.client.bu.project.cachedomain.servicedescriptor;



public class CollectionBuilder
		extends AbstractBuilder<CollectionType> {
	public CollectionBuilder() {
		this.builtObject = new CollectionType();
	}

	public CollectionBuilder itemType(Type itemType) {
		builtObject.setItemType(itemType);
		return this;
	}
	
}
