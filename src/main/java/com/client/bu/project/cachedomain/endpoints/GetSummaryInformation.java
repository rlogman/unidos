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
public class GetSummaryInformation extends ServiceDescriptorBuilder {

  public GetSummaryInformation() {
    name("getSummaryInformation")
    .description("")
    .urlPattern("")
    .filters(new Field[] {new FieldBuilder().name("tbdOther").type(StringType.class).build()})
    .returnType(new ObjectBuilder().fields(new Field[] {
        new FieldBuilder().name("date").type(DateTimeType.UTC_TIMESTAMP_YEAR).build(),
        new FieldBuilder().name("pairingAffected")
            .type(CrewSchedulingUtils.getPairingType()).build(),
        new FieldBuilder().name("crewAffected")
            .type(CrewSchedulingUtils.getCrewMemberType()).build(),
        new FieldBuilder().name("flightAffected")
            .type(CrewSchedulingUtils.getFlightLegType()).build(),
        new FieldBuilder().name("alertsDisplayed").type(StringType.class).build(),
        new FieldBuilder().name("alertsTotal").type(Int32.class).build(),}).build())
    .build();
  }
}
