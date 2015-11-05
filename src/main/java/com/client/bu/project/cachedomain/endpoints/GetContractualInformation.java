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
 * @since 1.0
 * @version 1.0
 */
public class GetContractualInformation extends ServiceDescriptorBuilder {

  public GetContractualInformation() {
    this.name("getContractualInformation");
    this.description("");
    this.urlPattern("");
    this.parameters(new Field[] {new FieldBuilder().name("alertId").type(StringType.class).build()});
    this.returnType(StringType.class).build();
  }
}
