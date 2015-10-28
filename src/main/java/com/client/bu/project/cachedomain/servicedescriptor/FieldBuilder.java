package com.client.bu.project.cachedomain.servicedescriptor;

import java.util.Set;

public class FieldBuilder
		extends AbstractBuilder<Field> {
	public FieldBuilder() {
		this.builtObject = new Field();
	}

	public FieldBuilder name(String name) {
		builtObject.setName(name);
		return this;
	}

	public FieldBuilder description(String description) {
		builtObject.setDescription(description);
		return this;
	}

	public FieldBuilder type(Type type) {
		builtObject.setType(type);
		return this;
	}

	public FieldBuilder type(Class<? extends Type> type) {
		try {
			builtObject.setType(type.newInstance());
		} catch (InstantiationException e) {
			throw new RuntimeException("Instance could not be built for " + type.getName(), e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Illegal access exception while building an instance for " + type.getName(), e);
		}
		return this;
	}

	public FieldBuilder deprecated(Boolean deprecated) {
		builtObject.setDeprecated(deprecated);
		return this;
	}

	public FieldBuilder optional(Boolean optional) {
		builtObject.setOptional(optional);
		return this;
	}

	public FieldBuilder possibleValues(Set<String> possibleValues) {
		builtObject.setPossibleValues(possibleValues);
		return this;
	}

	public FieldBuilder possibleValues(String[] possibleValues) {
		builtObject.setPossibleValues(toSet(possibleValues));
		return this;
	}
}
