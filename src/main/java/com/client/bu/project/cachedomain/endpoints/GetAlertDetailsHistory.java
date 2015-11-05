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
public class GetAlertDetailsHistory extends ServiceDescriptorBuilder {

  public GetAlertDetailsHistory() {
    name("getAlertDetailHistory")
    .description("")
    .urlPattern("")
    .filters(new Field[] {new FieldBuilder().name("alertId").type(StringType.class).build()})
    .returnType(new ObjectBuilder().fields(new Field[] {
        new FieldBuilder()
            .name("commentsAtPairingLevel")
            .type(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
                new FieldBuilder().name("newComment").type(StringType.class)
                    .build(),
                new FieldBuilder().name("expandComment").type(StringType.class)
                    .build(),
                new FieldBuilder().name("canClickToOpenParingView")
                    .type(StringType.class).build(),}).build()).build())
            .build(),
        new FieldBuilder()
            .name("commentsAtAlertLevel")
            .type(new CollectionBuilder().itemType(new ObjectBuilder().fields( new Field[] {
                new FieldBuilder().name("newComment").type(StringType.class)
                    .build(),
                new FieldBuilder().name("expandComment").type(StringType.class)
                    .build(),}).build()).build()).build(),
        new FieldBuilder().name("AlertAssignment").type(StringType.class).build(),
        new FieldBuilder().name("newWatchers").type(StringType.class).build(),
        new FieldBuilder()
            .name("flightUpdate")
            .type(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
                new FieldBuilder().name("changeStatus").type(StringType.class)
                    .build(),
                new FieldBuilder().name("changeOnDepartureTime")
                    .type(StringType.class).build(),
                new FieldBuilder().name("changeOnArrivalTime")
                    .type(StringType.class).build(),
                new FieldBuilder().name("tbdOther").type(StringType.class)
                    .build(),}).build()).build()).build(),}).build()).build();
  }
}
