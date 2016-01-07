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
public class TaskDocument extends ObjectBuilder {
 
    public TaskDocument() {
     fields(
                new Field[]{
                    new FieldBuilder().name("taskId")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("name")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("user")
                    .type(new ObjectBuilder().fields(new Field[]{
                        new FieldBuilder()
                        .name("username")
                        .type(StringType.class)
                        .build(),
                        new FieldBuilder()
                        .name("userId")
                        .type(StringType.class)
                        .build(),
                        new FieldBuilder()
                        .name("profile")
                        .type(StringType.class)
                        .build()})
                            .build()).build(),
                    new FieldBuilder().name("sinceTime")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("untilTime")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("assigment") 
                    .type(StringType.class).build(),
                    new FieldBuilder().name("status")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("status")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("type")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("taskAck") 
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
