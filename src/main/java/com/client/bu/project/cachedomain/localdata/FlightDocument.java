/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.bu.project.cachedomain.localdata;

import com.client.bu.project.cachedomain.servicedescriptor.CollectionBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.DateTimeType;
import com.client.bu.project.cachedomain.servicedescriptor.Field;
import com.client.bu.project.cachedomain.servicedescriptor.FieldBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.ObjectBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.StringType;

/**
 *
 * @author berenice.morales
 */
public class FlightDocument extends ObjectBuilder {

    public FlightDocument() {
        description("Describe all flights with its comments and data information").build();
        fields(
                new Field[]{
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
                    .type(DateTimeType.UTC_DATE)
                    .build(),
                    new FieldBuilder()
                    .name("actualDepartTime")
                    .type(DateTimeType.UTC_DATE)
                    .build(),
                    new FieldBuilder()
                    .name("scheduleArriveDatatime")
                    .type(DateTimeType.UTC_DATE)
                    .build(),
                    new FieldBuilder()
                    .name("actualArriveTime")
                    .type(DateTimeType.UTC_DATE)
                    .build(),
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
                                                            new FieldBuilder().name("fileURI")
                                                            .type(StringType.class).build(),
                                                            new FieldBuilder().name("fileName")
                                                            .type(StringType.class).build(),
                                                            new FieldBuilder().name("contentType")
                                                            .type(StringType.class)
                                                            .build()}).build()).build())
                                        .build()}).build()).build()).build()}).build();
    }
}
