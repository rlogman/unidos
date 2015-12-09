/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

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
public class GetAlertPreviewInformation extends ServiceDescriptorBuilder {


    public GetAlertPreviewInformation() {
        this.name("getAlertPreviewInformation");
        this.description("https://jira.globant.com/browse/UCI321-114");
        this.urlPattern("");
        this.filters(new Field[]{
            new FieldBuilder()
            .name("alertId")
            .type(StringType.class)
            .build(),});
        this.returnType(new ObjectBuilder().fields(new Field[]{
            new FieldBuilder()
            .name("severity")
            .type(StringType.class)
            .build(),
            new FieldBuilder().name("otherAlertsAffectingThisSameFlight")
            .type(Int32.class) // FIXME Validate type
            .build(),
            new FieldBuilder().name("watchersCount")
            .type(Int32.class)
            .build(),
            new FieldBuilder()
            .name("assignedIndicator")
            .type(StringType.class) // FIXME validate type
            .build(),
            new FieldBuilder()
            .name("pairingId")
            .type(StringType.class)
            .build(),
            new FieldBuilder()
            .name("affectedFACount")
            .type(Int32.class)
            .build(),
            new FieldBuilder()
            .name("affectedPilotsCount")
            .type(Int32.class)
            .build(),
            new FieldBuilder()
            .name("lastUpdated")
            .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
            .build(),
            new FieldBuilder()
            .name("flightNumber")
            .type(StringType.class)
            .build(),
            new FieldBuilder().name("fromAirport")
            .type(CrewSchedulingUtils.getAirportType())
            .build(),
            new FieldBuilder().name("toAirport")
            .type(CrewSchedulingUtils.getAirportType())
            .build(),
            new FieldBuilder()
            .name("date")
            .type(DateTimeType.UTC_DATE)
            .build(),
            new FieldBuilder()
            .name("pairingId")
            .type(StringType.class)
            .build(),
            new FieldBuilder().name("scheduledDepartureTimestamp")
            .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
            .build(),
            new FieldBuilder().name("scheduledArrivalTimestamp")
            .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
            .build(),
            new FieldBuilder().name("actualDepartureTimestamp")
            .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
            .build(),
            new FieldBuilder().name("actualArrivalTimestamp")
            .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
            .build(),}).build())
                .build();
    }

}
