package com.client.bu.project.cachedomain.servicedescriptor;

import java.util.Arrays;
import java.util.List;


public class ObjectBuilder
		extends AbstractBuilder<ObjectType> {
	public ObjectBuilder() {
		this.builtObject = new ObjectType();
	}

	public ObjectBuilder description(String description) {
		builtObject.setDescription(description);
		return this;
	}

	public ObjectBuilder type(String type) {
		builtObject.setType(type);
		return this;
	}

	public ObjectBuilder fields(List<Field> fields) {
		builtObject.setFields(fields);
		return this;
	}

	public ObjectBuilder fields(Field[] fields) {
		builtObject.setFields(Arrays.asList(fields));
		return this;
	}
	
}
