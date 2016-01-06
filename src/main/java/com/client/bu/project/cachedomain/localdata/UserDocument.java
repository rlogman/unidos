/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project.cachedomain.localdata;

import com.client.bu.project.cachedomain.servicedescriptor.Field;
import com.client.bu.project.cachedomain.servicedescriptor.FieldBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.ObjectBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.StringType;

/**
 *
 * @author berenice.morales
 */
public class UserDocument extends ObjectBuilder {

  public UserDocument() {
    fields(
        new Field[] {
        		new FieldBuilder().name("userId")
        				.type(StringType.class).build(),
                new FieldBuilder().name("username")
        				.type(StringType.class).build(),
                new FieldBuilder().name("email")
        				.type(StringType.class).build(),
                new FieldBuilder().name("profile")
        				.type(new ObjectBuilder().fields(new Field[] {
                                new FieldBuilder()
                                .name("idProfileDocument")
                                .type(StringType.class)
                                .build(),
                            new FieldBuilder()
                                .name("name")
                                .type(StringType.class)
                                .build(),})
                    .build()).build(),
        }).build();
  }
}
