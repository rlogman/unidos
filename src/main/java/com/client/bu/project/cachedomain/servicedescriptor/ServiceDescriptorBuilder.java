package com.client.bu.project.cachedomain.servicedescriptor;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptor.AvailabilityLevel;
import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptor.Maturity;
import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptor.Protocol;

public class ServiceDescriptorBuilder extends AbstractBuilder<ServiceDescriptor> {
  public ServiceDescriptorBuilder() {
    this.builtObject = new ServiceDescriptor();
  }

  public ServiceDescriptorBuilder name(String name) {
    builtObject.setName(name);
    return this;
  }

  public ServiceDescriptorBuilder description(String description) {
    builtObject.setDescription(description);
    return this;
  }

  public ServiceDescriptorBuilder returnType(Type returnType) {
    builtObject.setReturnType(returnType);
    return this;
  }

  public ServiceDescriptorBuilder returnType(Class<? extends Type> type) {
    try {
      builtObject.setReturnType(type.newInstance());
    } catch (InstantiationException e) {
      throw new RuntimeException("Instance could not be built for " + type.getName(), e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException("Illegal access exception while building an instance for "
          + type.getName(), e);
    }
    return this;
  }

  public ServiceDescriptorBuilder urlPattern(String urlPattern) {
    builtObject.setUrlPattern(urlPattern);
    return this;
  }

  public ServiceDescriptorBuilder maturity(Maturity maturity) {
    builtObject.setMaturity(maturity);
    return this;
  }

  public ServiceDescriptorBuilder protocols(Set<Protocol> protocols) {
    builtObject.setProtocols(protocols);
    return this;
  }

  public ServiceDescriptorBuilder protocol(Protocol[] protocols) {
    builtObject.setProtocols(toSet(protocols));
    return this;
  }

  public ServiceDescriptorBuilder availableTo(Set<AvailabilityLevel> availableTo) {
    builtObject.setAvailableTo(availableTo);
    return this;
  }

  public ServiceDescriptorBuilder availableTo(AvailabilityLevel[] availableTo) {
    builtObject.setAvailableTo(toSet(availableTo));
    return this;
  }

  public ServiceDescriptorBuilder filters(List<Field> filters) {
    builtObject.setFilters(filters);
    return this;
  }

  public ServiceDescriptorBuilder filters(Field[] filters) {
    builtObject.setFilters(Arrays.asList(filters));
    return this;
  }

  public ServiceDescriptorBuilder parameters(List<Field> parameters) {
    builtObject.setParameters(parameters);
    return this;
  }

  public ServiceDescriptorBuilder parameters(Field[] parameters) {
    builtObject.setParameters(Arrays.asList(parameters));
    return this;
  }
}
