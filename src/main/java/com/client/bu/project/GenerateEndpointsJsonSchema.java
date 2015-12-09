/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project;

import static com.client.bu.project.GenerationUtils.getJsonSchema;

import java.util.Set;

import org.reflections.Reflections;

import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptor;
import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptorBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.TypeObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;

/**
 *
 * @author berenice.morales <berenice.morales@globant.com>
 * @since 1.0.
 * @version 1.0.
 */
public class GenerateEndpointsJsonSchema {

  public static void main(String[] args) {
    try {
      Reflections reflections = new Reflections("com.client.bu.project.cachedomain.endpoints");
      Set<Class<? extends ServiceDescriptorBuilder>> allClasses =
          reflections.getSubTypesOf(ServiceDescriptorBuilder.class);

      ObjectMapper mapper = new ObjectMapper();
      SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
      boolean first = true;
      for (Class<? extends ServiceDescriptorBuilder> clazz : allClasses) {
        
//      Class<? extends ServiceDescriptorBuilder> clazz = GetMasterScheduleList.class;
        if (first) {
          System.out.printf("[%n");
          first = false;
        } else {
          System.out.printf(",%n");
        }
        ServiceDescriptor endpoint = clazz.newInstance().build();
        System.out.printf("{%n\"operation\": \"%s\",%n", endpoint.getName());
        System.out.printf("\"filters\": %s,%n", getJsonSchema(mapper, visitor, TypeObjectMapper.mapFiltersToObject(endpoint).getClass()));
        System.out.printf("\"response\": %s%n}", getJsonSchema(mapper, visitor, TypeObjectMapper.mapResponseToObject(endpoint).getClass()));
      }
      System.out.printf("]");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
