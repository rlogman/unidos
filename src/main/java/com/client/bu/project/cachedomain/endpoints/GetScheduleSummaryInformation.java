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
import com.client.bu.project.cachedomain.servicedescriptor.Int32;
import com.client.bu.project.cachedomain.servicedescriptor.ObjectBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptorBuilder;

/**
 *
 * @author berenice.morales
 * @since 1.0
 * @version 1.0
 */
public class GetScheduleSummaryInformation extends ServiceDescriptorBuilder {

    public GetScheduleSummaryInformation() {
        this.name("getScheduleSummaryInformation");
        this.description("");
        this.urlPattern("");
        this.filters(new Field[]{// TODO double-check this
        });
        this.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[]{
            new FieldBuilder().name("date")
            .type(DateTimeType.UTC_DATE)
            .build(),
            new FieldBuilder()
            .name("totalPairings")
            .type(Int32.class)
            .build(),
            new FieldBuilder()
            .name("totalFlights")
            .type(Int32.class)
            .build(),
            new FieldBuilder()
            .name("scheduledAlertsCount")
            .type(Int32.class)
            .build(),
            new FieldBuilder()
            .name("irropAlertsCount")
            .type(Int32.class)
            .build(),
            new FieldBuilder()
            .name("openAlertsCount")
            .type(Int32.class)
            .build(),
            new FieldBuilder()
            .name("totalAlertsCount")
            .type(Int32.class)
            .build(),
            new FieldBuilder()
            .name("totalsByAlertType")
            .type(new ObjectBuilder().fields(new Field[]{
                new FieldBuilder()
                .name("block")
                .type(Int32.class)
                .build(),
                new FieldBuilder()
                .name("duty")
                .type(Int32.class)
                .build(),
                new FieldBuilder()
                .name("farStaffing")
                .type(Int32.class)
                .build(),
                new FieldBuilder()
                .name("farCrewRest")
                .type(Int32.class)
                .build(),
                new FieldBuilder()
                .name("farQualifications")
                .type(Int32.class)
                .build(),
                new FieldBuilder()
                .name("farEntryDocumentation")
                .type(Int32.class)
                .build(),
                new FieldBuilder()
                .name("cancellation")
                .type(Int32.class)
                .build(),
                new FieldBuilder()
                .name("delay")
                .type(Int32.class)
                .build(),
                new FieldBuilder()
                .name("missconnection")
                .type(Int32.class)
                .build(),
                new FieldBuilder()
                .name("crewRestContract")
                .type(Int32.class)
                .build(),
                new FieldBuilder()
                .name("taxi")
                .type(Int32.class)
                .build(),
                new FieldBuilder()
                .name("uaStaffing")
                .type(Int32.class)
                .build(),
                new FieldBuilder()
                .name("unassignedInbound")
                .type(Int32.class)
                .build(),
                new FieldBuilder()
                .name("flightOnTime")
                .type(Int32.class)
                .build(),}).build())
            .build(),}).build()).build())
                .build();
    }
}
