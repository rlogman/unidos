/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.bu.project.cachedomain.localdata;

import com.client.bu.project.cachedomain.servicedescriptor.CollectionBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.Field;
import com.client.bu.project.cachedomain.servicedescriptor.FieldBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.ObjectBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.StringType;

/**
 *
 * @author berenice.morales
 */
public class AlertDocument extends ObjectBuilder {

    public AlertDocument() {
        description("Describe all alerts with its comments and data information").build();
        fields(
                new Field[]{
                    new FieldBuilder().name("alertId")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("alertType")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("flightLeg")
                    .type(new ObjectBuilder().fields(new Field[]{
                        new FieldBuilder()
                        .name("flightLegId")
                        .type(StringType.class)
                        .build(),
                        new FieldBuilder()
                        .name("fromAirportCode")
                        .type(StringType.class)
                        .build(),
                        new FieldBuilder()
                        .name("toAirportCode")
                        .type(StringType.class)
                        .build(),
                        new FieldBuilder()
                        .name("aircraftId")
                        .type(StringType.class)
                        .build(),
                        new FieldBuilder()
                        .name("flightNumber")
                        .type(StringType.class)
                        .build(),
                        new FieldBuilder()
                        .name("scheduleDepartDatatime")
                        .type(StringType.class)
                        .build(),
                        new FieldBuilder()
                        .name("actualDepartTime")
                        .type(StringType.class)
                        .build(),
                        new FieldBuilder()
                        .name("scheduleArriveDatatime")
                        .type(StringType.class)
                        .build(),
                        new FieldBuilder()
                        .name("actualArriveTime")
                        .type(StringType.class)
                        .build(),})
                            .build()).build(),
                    new FieldBuilder().name("eventId")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("triggeringTimestamp")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("alertJsonData")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("status")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("comments")
                    .type(new CollectionBuilder().itemType(
                            new ObjectBuilder().fields(new Field[]{
                                new FieldBuilder().name("commentId")
                                .type(StringType.class).build(),
                                new FieldBuilder().name("user")
                                .type(StringType.class).build(),
                                new FieldBuilder().name("comment")
                                .type(StringType.class).build(),
                                new FieldBuilder().name("commentAttachment")
                                .type(new CollectionBuilder().itemType(
                                     new ObjectBuilder().fields(new Field[]{
                                        new FieldBuilder().name("file")
                                        .type(StringType.class).build(),
                                        new FieldBuilder().name("fileName")
                                        .type(StringType.class).build(),
                                        new FieldBuilder().name("contectType")
                                        .type(StringType.class)
                               .build()}).build()).build())
                               .build()}).build()).build()).build()
                })
                .build();
    }
}