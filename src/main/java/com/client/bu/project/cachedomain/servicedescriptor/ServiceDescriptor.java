package com.client.bu.project.cachedomain.servicedescriptor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ServiceDescriptor {
	private String urlPattern;
	private String name;
	private Maturity maturity;
	private Set<AvailabilityLevel> availableTo;
	private String description;
	private Set<Protocol> protocols;
	private List<Field> parameters;
	private Type returnType;

	public enum Protocol {
		HTTP, HTTPS;
	}

	public enum AvailabilityLevel {
		Anonymous, Authenticated, Authorized;
	}

	public enum Maturity {
		Stable, Alpha, Beta, Deprecated;
	}

	public ServiceDescriptor(String name, String description,
			String urlPattern, List<Field> parameters, Type returnType,
			Maturity maturity, Set<AvailabilityLevel> availableTo,
			Set<Protocol> protocols) {
		super();
		this.name = name;
		this.description = description;
		this.urlPattern = urlPattern;
		this.parameters = parameters;
		this.returnType = returnType;
		this.maturity = maturity;
		this.availableTo = availableTo;
		this.protocols = protocols;
	}

	public static <T> Set<T> toSet(T[] items) {
		Set<T> set = new HashSet<T>();
		for (T protocol : items) {
			set.add(protocol);
		}
		return set;
	}

	public ServiceDescriptor() {
	}

	public ServiceDescriptor(String name, String description,
			String urlPattern, Field[] parameters, Type returnType,
			Maturity maturity, AvailabilityLevel[] availableTo,
			Protocol[] protocols) {
		this(name, description, urlPattern, Arrays.asList(parameters),
				returnType, maturity, toSet(availableTo), toSet(protocols));
	}

	public String getUrlPattern() {
		return urlPattern;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Maturity getMaturity() {
		return maturity;
	}

	public void setMaturity(Maturity maturity) {
		this.maturity = maturity;
	}

	public Set<AvailabilityLevel> getAvailableTo() {
		return availableTo;
	}

	public void setAvailableTo(Set<AvailabilityLevel> availableTo) {
		this.availableTo = availableTo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Protocol> getProtocols() {
		return protocols;
	}

	public void setProtocols(Set<Protocol> protocols) {
		this.protocols = protocols;
	}

	public List<Field> getParameters() {
		return parameters;
	}

	public void setParameters(List<Field> parameters) {
		this.parameters = parameters;
	}

	public Type getReturnType() {
		return returnType;
	}

	public void setReturnType(Type returnType) {
		this.returnType = returnType;
	}
}
