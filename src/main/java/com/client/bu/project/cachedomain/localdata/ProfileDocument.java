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
public class ProfileDocument extends ObjectBuilder {

    public ProfileDocument() {
        description("Contain data information about profile").build();
        fields(
                new Field[]{
                    new FieldBuilder().name("properties")
                    .type(new CollectionBuilder().itemType(
                                    new ObjectBuilder().fields(new Field[]{
                                        new FieldBuilder().name("idPropertiesDocument")
                                        .type(StringType.class).build(),
                                        new FieldBuilder().name("label")
                                        .type(StringType.class).build(),
                                        new FieldBuilder().name("value")
                                        .type(StringType.class).build(),
                                        new FieldBuilder().name("group")
                                        .type(
                                                new ObjectBuilder().fields(new Field[]{
                                                    new FieldBuilder().name("code")
                                                    .type(StringType.class).build(),
                                                    new FieldBuilder().name("label")
                                                    .type(StringType.class).build(),}).build())
                                        .build()}).build()).build()).build(),
                    new FieldBuilder().name("filters")
                    .type(new CollectionBuilder().itemType(
                                    new ObjectBuilder().fields(new Field[]{
                                        new FieldBuilder().name("idFilterDocument")
                                        .type(StringType.class).build(),
                                        new FieldBuilder().name("name")
                                        .type(StringType.class).build(),
                                        new FieldBuilder().name("fielBy")
                                        .type(StringType.class).build(),
                                        new FieldBuilder().name("timeframe")
                                        .type(StringType.class).build(),
                                        new FieldBuilder().name("filterExclusion")
                                        .type(new CollectionBuilder().itemType(
                                                        new ObjectBuilder().fields(new Field[]{
                                                            new FieldBuilder().name("id")
                                                            .type(StringType.class).build(),
                                                            new FieldBuilder().name("name")
                                                            .type(StringType.class).build(),
                                                            new FieldBuilder().name("fieldBy")
                                                            .type(StringType.class)
                                                            .build()}).build()).build())
                                        .build()}).build()).build()).build(),
                    new FieldBuilder().name("dashboards")
                    .type(new CollectionBuilder().itemType(
                                    new ObjectBuilder().fields(new Field[]{
                                        new FieldBuilder().name("idDashboard")
                                        .type(StringType.class).build(),
                                        new FieldBuilder().name("name")
                                        .type(StringType.class).build(),
                                        new FieldBuilder().name("layoutGrid")
                                        .type(StringType.class).build(),
                                        new FieldBuilder().name("dashboardWidget")
                                        .type(new CollectionBuilder().itemType(
                                                        new ObjectBuilder().fields(new Field[]{
                                                            new FieldBuilder().name("id")
                                                            .type(StringType.class).build(),
                                                            new FieldBuilder().name("code")
                                                            .type(StringType.class).build(),
                                                            new FieldBuilder().name("sequence")
                                                            .type(StringType.class).build(),
                                                            new FieldBuilder().name("name")
                                                            .type(StringType.class).build(),
                                                            new FieldBuilder().name("markup")
                                                            .type(StringType.class).build()
                                                            }).build()).build())
                                        .build()}).build()).build()).build()}).build();
    }
}
