package com.client.bu.project.cachedomain.servicedescriptor;

import java.util.Set;

public class Field {
	private String name;
	private String description;
	private Type type;
	private Set<String> possibleValues;
	private Boolean optional;
	private Boolean deprecated;

	public Field(String name, String description, Type type,
			Set<String> possibleValues, Boolean optional, Boolean deprecated) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.possibleValues = possibleValues;
		this.optional = optional;
		this.deprecated = deprecated;
	}

	public Field() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Boolean isOptional() {
		return optional;
	}

	public void setOptional(Boolean optional) {
		this.optional = optional;
	}

	public Boolean isDeprecated() {
		return deprecated;
	}

	public void setDeprecated(Boolean deprecated) {
		this.deprecated = deprecated;
	}

	public Set<String> getPossibleValues() {
		return possibleValues;
	}

	public void setPossibleValues(Set<String> possibleValues) {
		this.possibleValues = possibleValues;
	}
}
