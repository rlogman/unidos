/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

import com.client.bu.project.cachedomain.servicedescriptor.CollectionBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.Field;
import com.client.bu.project.cachedomain.servicedescriptor.FieldBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.ObjectBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptorBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.StringType;

/**
 *
 * @author berenice.morales
 * @since 1.0
 * @version 1.0
 */
public class GetAlertManagementDashboard extends ServiceDescriptorBuilder {

  public GetAlertManagementDashboard() {
    this.name("local.getAlertManagementDashboard");
    this.description("");
    this.urlPattern("");
    this.filters(new Field[] {new FieldBuilder().name("profileId") // TODO double-check this; it
                                                                   // seems invalid
        .type(StringType.class).build(),});
    this.returnType(
        new CollectionBuilder()
            .itemType(
                new ObjectBuilder().fields(new Field[] { // TODO double-check whole return; it seems
                                                         // invalid
                    new FieldBuilder().name("name").type(StringType.class).build(),
                        new FieldBuilder().name("description").type(StringType.class).build(),
                        new FieldBuilder().name("accessLink").type(StringType.class).build(),})
                    .build()).build()).build();
  }
}
