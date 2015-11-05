/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

import static com.client.bu.project.cachedomain.util.CrewSchedulingUtils.*;

import com.client.bu.project.cachedomain.servicedescriptor.CollectionBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.DateTimeType;
import com.client.bu.project.cachedomain.servicedescriptor.Field;
import com.client.bu.project.cachedomain.servicedescriptor.FieldBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.Int32;
import com.client.bu.project.cachedomain.servicedescriptor.ObjectBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptorBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.StringType;

/**
 *
 * @author berenice.morales
 * @since 1.0
 * @version 1.0
 */
public class GetMasterScheduleList extends ServiceDescriptorBuilder {

  public GetMasterScheduleList() {
    name("getMasterScheduleList")
    .description("")
    .urlPattern("")
    .filters(new Field[] { // TODO Validate
        new FieldBuilder().name("crewMemberId").type(StringType.class).build(),})
    .returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
        new FieldBuilder().name("position").type(StringType.class)
            .possibleValues(new String[] {}).build(),
        new FieldBuilder().name("firstName").type(StringType.class).build(),
        new FieldBuilder().name("lastName").type(StringType.class).build(),
        new FieldBuilder().name("domicile").type(getDomicileType()).build(),
        new FieldBuilder().name("cellPhone").type(StringType.class).build(),
        new FieldBuilder()
            .name("alertsAssociated")
            .type(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
                new FieldBuilder().name("flightNumber")
                    .type(StringType.class).build(),
                new FieldBuilder().name("severity")
                    .type(StringType.class)
                    .possibleValues(new String[] {
                    // FIXME provide possible values
                    }).build(),
                new FieldBuilder().name("type")
                    .type(StringType.class)
                    .possibleValues(new String[] { // FIXME provide possible values
                    }).build(),
                new FieldBuilder()
                    .name("pairingsAffected") // TODO is this an enumeration or a count?
                    .type(new CollectionBuilder().itemType(StringType.class).build()) // TODO Validate
                    .build(),
                new FieldBuilder().name("affectedFACount")
                    .type(Int32.class).build(),
                new FieldBuilder().name("affectedPilotsCount")
                    .type(Int32.class).build(),
                new FieldBuilder()
                    .name("scheduledDepartureTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                new FieldBuilder()
                    .name("scheduledArrivalTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                new FieldBuilder()
                    .name("estimatedDepartureTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                new FieldBuilder()
                    .name("estimatedArrivalTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                new FieldBuilder().name("actualDepartureTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                new FieldBuilder().name("actualArrivalTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                new FieldBuilder().name("local.assignee")
                    .type(StringType.class).build(),
                new FieldBuilder()
                    .name("local.watchers")
                    .type(new CollectionBuilder().itemType(StringType.class).build()).build(),
                new FieldBuilder().name("lastUpdate")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),}).build()).build()).build(),
        new FieldBuilder()
            .name("monthsAvailable")
            .type(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
                new FieldBuilder().name("month")
                    .type(DateTimeType.UTC_MONTH).build(),
                new FieldBuilder()
                    .name("flightSegments")
                    .type(new CollectionBuilder().itemType(getAlertDetailsType()).build())
                    .build(),
                new FieldBuilder()
                    .name("nonFlyingSegments")
                    .type(new CollectionBuilder().itemType(getMasterScheduleNonFlyingSegmentType()).build())
                    .build(),
                new FieldBuilder()
                    .name("flyingAlerts")
                    .type(new CollectionBuilder().itemType(getAlertDetailsType()).build())
                    .build(),
                new FieldBuilder()
                    .name("nonFlyingAlerts")
                    .type(new CollectionBuilder().itemType(getAlertDetailsType()).build())
                    .build(),
            }).build()).build()).build(),
        new FieldBuilder().name("lastUpdate")
            .type(DateTimeType.UTC_TIMESTAMP_SECONDS).build(),}).build()).build())
    .build();
  }
}
