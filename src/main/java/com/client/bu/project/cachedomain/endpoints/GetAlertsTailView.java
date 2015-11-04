/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

import com.client.bu.project.cachedomain.servicedescriptor.BooleanType;
import com.client.bu.project.cachedomain.servicedescriptor.CollectionBuilder;
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
public class GetAlertsTailView extends ServiceDescriptorBuilder {

    public GetAlertsTailView() {
        this.name("getAlertsTailView");
        this.description("");
        this.urlPattern("");
        this.filters(new Field[]{
            CrewSchedulingUtils.getTimeframeField(),
            new FieldBuilder().name("sortType")
            .possibleValues(new String[]{
                "tailNumber",
                "scheduledDepartureTime",
                "estimatedDepartureTime",
                "actualDepartureTime",
                "scheduledArrivalTime",
                "estimatedArrivalTime",
                "actualArrivaleTime",
                "highestSeverityFirst",})
            .type(StringType.class).build(),});
        this.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[]{
            new FieldBuilder()
            .name("tailNumber")
            .type(StringType.class)
            .build(),
            new FieldBuilder().name("fromAirport")
            .type(CrewSchedulingUtils.getAirportType())
            .build(),
            new FieldBuilder().name("toAirport")
            .type(CrewSchedulingUtils.getAirportType())
            .build(),
            new FieldBuilder()
            .name("severityIndicator")
            .type(StringType.class)
            .build(),
            new FieldBuilder()
            .name("alertTypeCategory")
            .type(StringType.class)
            .build(),
            new FieldBuilder()
            .name("alertTypeSubCategory")
            .type(StringType.class)
            .build(),
            new FieldBuilder()
            .name("local.assignedIndicator")
            .type(BooleanType.class)
            .build(),
            new FieldBuilder()
            .name("local.watchedByMeIndicator")
            .type(BooleanType.class)
            .build(),}).build()).build())
                .build();
    }
}
