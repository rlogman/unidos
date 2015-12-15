/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Set;

import org.reflections.Reflections;

import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptor;
import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptorBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author berenice.morales <berenice.morales@globant.com>
 * @since 1.0.
 * @version 1.0.
 */
public class GenerateJsonEndpointFiles {

	public static void main(String[] args) {
		try {
			String root = args[0];
			Reflections reflections = new Reflections("com.client.bu.project.cachedomain.endpoints");
			Set<Class<? extends ServiceDescriptorBuilder>> allClasses = reflections
					.getSubTypesOf(ServiceDescriptorBuilder.class);

			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			for (Class<? extends ServiceDescriptorBuilder> allClasse : allClasses) {
				generateFile(mapper, root, allClasse.newInstance().build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void generateFile(ObjectMapper mapper, String root, ServiceDescriptor endpoint) throws FileNotFoundException, JsonProcessingException {
		File f = new File(root, extractName(endpoint));
		PrintWriter out = new PrintWriter(f);
		out.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(endpoint));
		out.close();
	}

	private static String extractName(ServiceDescriptor endpoint) {
		String description = endpoint.getDescription();
		int pos = description.lastIndexOf("browse/");
		String usSegment = (pos != -1) ? description.substring(pos + 7) : description;
		return usSegment + "-" + endpoint.getName() + ".json";
	}
}
