package com.client.bu.project.cachedomain.servicedescriptor;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"kind", "type"})
public abstract class Primitive extends Type {
  public java.lang.String getKind() {
    return "Primitive";
  }

  public abstract java.lang.String getType();
}
