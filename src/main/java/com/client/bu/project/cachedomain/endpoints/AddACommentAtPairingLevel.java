/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

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
public class AddACommentAtPairingLevel extends ServiceDescriptorBuilder  {
    
    public AddACommentAtPairingLevel(){
        this.name("addACommentAtPairingLevel");
        this.description("");
        this.urlPattern("");
        this.filters(
                new Field[]{
                    new FieldBuilder().name("paringId")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("userId")
                    .type(StringType.class).build(),
                    new FieldBuilder().name("description")
                    .type(StringType.class).build(),
                    new FieldBuilder()
                    .name("tbdOther")
                    .type(StringType.class)
                    .build()});

        this.returnType(
                new ObjectBuilder().fields(
                        new Field[]{
                            new FieldBuilder()
                            .name("tbdOther")
                            .type(StringType.class)
                            .build()}).build())
                .build();
    }
}
