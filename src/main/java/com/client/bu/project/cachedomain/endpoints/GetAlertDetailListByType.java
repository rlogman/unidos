/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

import com.client.bu.project.cachedomain.servicedescriptor.CollectionBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.DateTimeType;
import com.client.bu.project.cachedomain.servicedescriptor.Field;
import com.client.bu.project.cachedomain.servicedescriptor.FieldBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.ObjectBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptorBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.StringType;
import com.client.bu.project.cachedomain.util.CrewSchedulingUtils;

/**
 *
 * @author berenice.morales
 */
public class GetAlertDetailListByType extends ServiceDescriptorBuilder {
    
    public GetAlertDetailListByType(){
        this.name("getAlertDetailListByType");
        this.description("");
        this.urlPattern("");
        this.parameters(new Field[]{
            new FieldBuilder().name("type")
            .type(StringType.class).build(),
            new FieldBuilder().name("general")
            .type(StringType.class)
            .possibleValues(new String[]{"high", "medium", "low"}).build(),
            CrewSchedulingUtils.getTimeframeField(),
           new FieldBuilder().name("sortType")
            .possibleValues(new String[]{
                "severity",
                "lastUpdate",
                "pairing",})
            .type(StringType.class).build()
        }
        );
        this.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[]{
            new FieldBuilder().name("severity")
            .type(StringType.class)
            .build(),
            new FieldBuilder()
            .name("lastUpdate")
            .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
            .build(),
            new FieldBuilder()
            .name("pairing")
            .type(CrewSchedulingUtils.getPairingCollectionType())
            .build(),
            new FieldBuilder()
            .name("flight")
            .type(CrewSchedulingUtils.getPairingCollectionType())
            .build(),
            new FieldBuilder()
            .name("crew")
            .type(CrewSchedulingUtils.getCrewMemberCollectionType())
            .build(),}).build()).build()).build();
    }
}
