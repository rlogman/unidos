/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

import com.client.bu.project.cachedomain.servicedescriptor.BooleanType;
import com.client.bu.project.cachedomain.servicedescriptor.CollectionBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.DecimalType;
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
public class GetTimezones extends ServiceDescriptorBuilder {

    public GetTimezones() {
        this.name("local.getTimezones");
        this.description("");
        this.urlPattern("");
        this.parameters(new Field[]{});
        this.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[]{
            new FieldBuilder()
            .name("name")
            .type(StringType.class)
            .build(),
            new FieldBuilder()
            .name("abbreviation")
            .type(StringType.class)
            .build(),
            new FieldBuilder()
            .name("utcOffset")
            .type(DecimalType.class)
            .build(),
            new FieldBuilder()
            .name("isDefault")
            .type(BooleanType.class)
            .build(),}).build()).build())
                .build();
    }
}
