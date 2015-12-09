/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

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
 */
public class GetAlertsCalendar extends ServiceDescriptorBuilder {

    public GetAlertsCalendar() {
        this.name("seeAlertsCalendar");
        this.description("https://jira.globant.com/browse/UCI321-164");
        this.urlPattern("");
        this.filters(new Field[]{
            new FieldBuilder().name("month")
            .type(StringType.class).build(),
            new FieldBuilder().name("filter")
            .possibleValues(new String[]{
                "all",
                "severity",
                "type"})
            .type(StringType.class).build()
        }
        );
        this.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[]{
            new FieldBuilder().name("dayOfMonth")
            .type(StringType.class)
            .build(),
            new FieldBuilder()
            .name("totalAlerts")
            .type(StringType.class)
            .build(),
            new FieldBuilder()
            .name("alerts")
            .type(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[]{
                new FieldBuilder()
                .name("alertId")
                .type(StringType.class)
                .build(),
                new FieldBuilder()
                .name("pairing")
                .type(CrewSchedulingUtils.getPairingCollectionType())
                .build(),
                new FieldBuilder().name("flight")
                .type(CrewSchedulingUtils.getFlightLegType())
                .build(),
                new FieldBuilder().name("crew")
                .type(CrewSchedulingUtils.getCrewMemberCollectionType())
                .build(),
                new FieldBuilder()
                .name("watchers")
                .type(CrewSchedulingUtils.getWatchers())
                .build(),
                new FieldBuilder()
                .name("assignedTo")
                .type(StringType.class)
                .build()}).build()).build())
            .build()}).build()).build()).build();
    }
}
