/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

import com.client.bu.project.cachedomain.servicedescriptor.BooleanType;
import com.client.bu.project.cachedomain.servicedescriptor.DateTimeType;
import com.client.bu.project.cachedomain.servicedescriptor.Field;
import com.client.bu.project.cachedomain.servicedescriptor.FieldBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.Int32;
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
public class GetMasterScheduleList extends ServiceDescriptorBuilder {

    public GetMasterScheduleList() {
        this.name("getMasterScheduleList");
        this.description("");
        this.urlPattern("");
        this.returnType(new ObjectBuilder().fields(new Field[]{
            new FieldBuilder()
            .name("id")
            .type(StringType.class)
            .build(),
            new FieldBuilder().name("position")
            .type(Int32.class)
            .build(),
            new FieldBuilder().name("seniority")
            .type(StringType.class)
            .build(),
            new FieldBuilder()
            .name("fullname")
            .type(StringType.class) // FIXME validate type
            .build(),
            new FieldBuilder()
            .name("domicile")
            .type(StringType.class)
            .build(),
            new FieldBuilder()
            .name("cellphone")
            .type(Int32.class)
            .build(),
            new FieldBuilder()
            .name("alertAssociated")
            .type(StringType.class)
            .build(),
            new FieldBuilder()
            .name("lastUpdated")
            .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
            .build(),
            new FieldBuilder()
            .name("alertInformation")
            .type(new ObjectBuilder().fields(new Field[]{
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
                .type(StringType.class)
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
                .build(),}).build())
            .build(),
            new FieldBuilder().name("masterSchedule")
            .type(new ObjectBuilder().fields(new Field[]{
                new FieldBuilder().name("flightSegments")
                .type(Int32.class)
                .build(),
                new FieldBuilder().name("nonFlyingActivities")
                .type(StringType.class)
                .build(),
                new FieldBuilder().name("flyingAlerts")
                .type(StringType.class)
                .build(),
                new FieldBuilder().name("NoFlyingAlerts")
                .type(StringType.class)
                .build(),}).build())
            .build(),}).build())
                .build();
    }
}
