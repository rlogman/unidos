/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import com.client.bu.project.cachedomain.servicedescriptor.ObjectBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.ObjectType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author berenice.morales <berenice.morales@globant.com>
 * @since 1.0.
 * @version 1.0.
 */
public class GenerateJsonLocalDataSpecs {

  public static void main(String[] args) {
    try {
      List<ObjectType> endpoints = new ArrayList<>();
      Reflections reflections = new Reflections("com.client.bu.project.cachedomain.localdata");
      Set<Class<? extends ObjectBuilder>> allClasses =
          reflections.getSubTypesOf(ObjectBuilder.class);

      for (Class<? extends ObjectBuilder> clazz : allClasses) {
        endpoints.add(clazz.newInstance().build());
      }
      ObjectMapper mapper = new ObjectMapper();
      mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
      System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(endpoints));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
