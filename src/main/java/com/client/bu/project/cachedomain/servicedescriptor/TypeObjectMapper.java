package com.client.bu.project.cachedomain.servicedescriptor;

import java.util.List;

import net.sf.cglib.beans.BeanGenerator;

public class TypeObjectMapper {
  
  public static Object mapFiltersToObject(ServiceDescriptor s) {
    BeanGenerator g = new BeanGenerator();
    g.setSuperclass(Object.class);
    addFieldsToObjectStructure(s.getFilters(), g);
    return g.create();
  }
  
  public static Object mapResponseToObject(ServiceDescriptor s) {
    BeanGenerator g = new BeanGenerator();
    g.setSuperclass(Object.class);
    addResponseFieldsToObjectStructure(s.getReturnType(), g);
    return g.create();
  }

  private static void addResponseFieldsToObjectStructure(Type returnType, BeanGenerator g) {
    if (returnType instanceof CollectionType) {
      addResponseFieldsToObjectStructure(((CollectionType) returnType).getItemType(), g);
    } else if (returnType instanceof ObjectType) {
      addFieldsToObjectStructure(((ObjectType) returnType).getFields(), g);
    } else if (returnType instanceof VoidType) {
      // do nothing
    } else {
      g.addProperty("response", returnType.getObjectSample().getClass());
    }
  }

  public static void addFieldsToObjectStructure(List<Field> fields, BeanGenerator g) {
    if (fields == null) {
      return;
    }
    for (Field field: fields) {
      try {
        g.addProperty(field.getName(), field.getType().getObjectSample().getClass());
      } catch (Exception e) {
        // ignore
      }
    }
  }
}
