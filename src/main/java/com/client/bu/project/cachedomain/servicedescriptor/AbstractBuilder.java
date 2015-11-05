package com.client.bu.project.cachedomain.servicedescriptor;

import java.util.HashSet;
import java.util.Set;

public class AbstractBuilder<D> {
  protected D builtObject;

  public static <T> Set<T> toSet(T[] items) {
    Set<T> set = new HashSet<T>();
    for (T protocol : items) {
      set.add(protocol);
    }
    return set;
  }

  public AbstractBuilder<D> create() {
    return new AbstractBuilder<D>();
  }

  public D build() {
    return builtObject;
  }

}
