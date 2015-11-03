/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.bu.project;

import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptor;
import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptorBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.reflections.Reflections;

/**
 *
 * @author berenice.morales <berenice.morales@globant.com>
 * @since 1.0.
 * @version 1.0.
 */
public class GenerateJsonEndpoints {

    public static void main(String[] args) {
        try {
            List<ServiceDescriptor> endpoints = new ArrayList<ServiceDescriptor>();
            Reflections reflections = new Reflections("com.client.bu.project.cachedomain.endpoints");
            Set<Class<? extends ServiceDescriptorBuilder>> allClasses = reflections.getSubTypesOf(ServiceDescriptorBuilder.class);
            
            for (Class<? extends ServiceDescriptorBuilder> allClasse : allClasses) {
                endpoints.add( allClasse.newInstance().build());
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            System.out.println(mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(endpoints));
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
