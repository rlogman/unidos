/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

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
public class GetPairingSummaryInformation extends ServiceDescriptorBuilder {

  public GetPairingSummaryInformation() {
    name("getPairingSummaryInformation")
    .description("https://jira.globant.com/browse/UCI321-12")
    .urlPattern("")
    .filters(CrewSchedulingUtils.getTimeframeAndTypeFieldArray())
    .returnType(
        new ObjectBuilder().fields(
            new Field[] {
                new FieldBuilder().name("affectedPairings")
                    .type(CrewSchedulingUtils.getPairingCollectionType()).build(),
                new FieldBuilder().name("alertCount").type(StringType.class).build(),
                new FieldBuilder().name("date").type(DateTimeType.UTC_TIMESTAMP_YEAR).build(),
                new FieldBuilder().name("flightCount").type(StringType.class).build(),
                new FieldBuilder().name("openPairings")
                    .type(CrewSchedulingUtils.getPairingCollectionType()).build(),
                new FieldBuilder().name("pairingsCount").type(StringType.class).build(),
                new FieldBuilder().name("scheduledPairings")
                    .type(CrewSchedulingUtils.getPairingCollectionType()).build(),}).build())
        .build();
  }
}
