package com.client.bu.project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;

public class GenerationUtils {

  public static <T> String getJsonSchema(ObjectMapper mapper, SchemaFactoryWrapper visitor,
      Class<T> clazz) throws JsonProcessingException {
    mapper.acceptJsonFormatVisitor(clazz, visitor);
    JsonSchema schema = visitor.finalSchema();
    return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);
  }

}
