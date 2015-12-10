package com.client.bu.project.cachedomain.servicedescriptor;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class Type {
  public abstract String getKind();

  @JsonIgnore
  public abstract Object getObjectSample();
}
