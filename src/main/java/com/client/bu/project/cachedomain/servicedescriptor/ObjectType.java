package com.client.bu.project.cachedomain.servicedescriptor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"kind", "type", "description", "fields"})
public class ObjectType extends Type {
  private String type;
  private String description;
  private List<Field> fields;

  public ObjectType(String type, String description, List<Field> fields) {
    super();
    this.type = type;
    this.description = description;
    this.fields = fields;
  }

  public ObjectType() {}

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Field> getFields() {
    return fields;
  }

  public void setFields(List<Field> fields) {
    this.fields = fields;
  }

  @Override
  public java.lang.String getKind() {
    return "Object";
  }
}
