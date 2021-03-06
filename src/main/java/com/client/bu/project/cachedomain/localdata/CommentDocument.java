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
public class CommentDocument extends ObjectBuilder {

    public CommentDocument() {
        description("Describe all comment with its parent and data information").build();
        fields(
                new Field[]{
                    new FieldBuilder().name("commentId")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("parent")
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
                    .build()})
                .build();
    }
}
