/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

import com.client.bu.project.cachedomain.servicedescriptor.Field;
import com.client.bu.project.cachedomain.servicedescriptor.FieldBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptorBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.StringType;

/**
 *
 * @author berenice.morales
 */
public class GetLegalityInformation extends ServiceDescriptorBuilder {

  public GetLegalityInformation() {
    name("getLegalityInformation")
    .description("https://jira.globant.com/browse/UCI321-30")
    .urlPattern("")
    .filters(new Field[] {new FieldBuilder().name("alertId").type(StringType.class).build()})
    .returnType(StringType.class).build();
  }
}
