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
 * @since 1.0
 * @version 1.0
 */
public class GetAlertsAssociatedToAParing extends ServiceDescriptorBuilder {

    public GetAlertsAssociatedToAParing() {
        this.name("getAlertsAssociatedToAParing");
        this.description("");
        this.urlPattern("");
        this.filters(new Field[]{
            CrewSchedulingUtils.getTimeframeField(),
            new FieldBuilder().name("pairingId")
            .type(StringType.class).build()

        });
        this.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[]{
            new FieldBuilder()
            .name("severity")
            .type(StringType.class)
            .build(),
            new FieldBuilder().name("alertType")
            .type(StringType.class)
            .build(),
            new FieldBuilder().name("affectedPairings")
            .type(CrewSchedulingUtils.getPairingCollectionType())
            .build(),
            new FieldBuilder().name("crewAffected")
            .type(CrewSchedulingUtils.getCrewMemberCollectionType())
            .build(),
            new FieldBuilder()
            .name("numberFlight")
            .type(StringType.class)
            .build(),
            new FieldBuilder()
            .name("assignedTo")
            .type(StringType.class)
            .build(),
            new FieldBuilder()
            .name("watchers")
            .type(CrewSchedulingUtils.getWatchers())
            .build(),
            new FieldBuilder()
            .name("lastUpdate")
            .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
            .build(),
            new FieldBuilder().name("scheduledDepartureTimestamp")
            .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
            .build(),
            new FieldBuilder().name("actualDepartureTimestamp")
            .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
            .build(),
            new FieldBuilder().name("scheduledArrivalTimestamp")
            .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
            .build(),
            new FieldBuilder().name("actualArrivalTimestamp")
            .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
            .build(),}).build()).build());
    }
    
    
}
