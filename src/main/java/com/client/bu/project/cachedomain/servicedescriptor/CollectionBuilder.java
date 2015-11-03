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

	public CollectionBuilder itemType(Class<? extends Type> type) {
		try {
			builtObject.setItemType(type.newInstance());
		} catch (InstantiationException e) {
			throw new RuntimeException("Instance could not be built for " + type.getName(), e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Illegal access exception while building an instance for " + type.getName(), e);
		}
		return this;
	}
	
}
