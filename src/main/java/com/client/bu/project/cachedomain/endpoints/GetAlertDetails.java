/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

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
public class GetAlertDetails extends ServiceDescriptorBuilder {

  public GetAlertDetails() {
    name("getAlertDetail")
    .description("")
    .urlPattern("")
    .filters(new Field[] {new FieldBuilder().name("alertId").type(StringType.class).build()})
    .returnType(new ObjectBuilder().fields(new Field[] {
        new FieldBuilder().name("pairing")
            .type(CrewSchedulingUtils.getPairingCollectionType()).build(),
        new FieldBuilder().name("flight").type(CrewSchedulingUtils.getFlightLegType())
            .build(),
        new FieldBuilder().name("crew")
            .type(CrewSchedulingUtils.getCrewMemberCollectionType()).build(),
        new FieldBuilder().name("watchers").type(Int32.class)
            .build(),
        new FieldBuilder().name("assignedTo").type(StringType.class).build()}).build())
    .build();
  }

}
