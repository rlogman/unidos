/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

import com.client.bu.project.cachedomain.servicedescriptor.CollectionBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.DateTimeType;
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
public class GetCommentsAssociatedToAPairing extends ServiceDescriptorBuilder {

  public GetCommentsAssociatedToAPairing() {
    name("getCommentsAssociatedToAPairing")
    .description("")
    .urlPattern("")
    .filters(new Field[] {new FieldBuilder().name("paringId").type(StringType.class).build(),})
    .returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
        new FieldBuilder().name("commentId").type(StringType.class).build(),
        new FieldBuilder().name("description").type(StringType.class).build(),
        new FieldBuilder().name("who").type(StringType.class)// TODO? client list?
            .build(),
        new FieldBuilder().name("lastUpdate").type(DateTimeType.UTC_TIMESTAMP_MINUTES)
            .build(),}).build()).build());
  }
}
