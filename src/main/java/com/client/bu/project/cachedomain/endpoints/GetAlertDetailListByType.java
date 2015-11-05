/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

import static com.client.bu.project.cachedomain.util.CrewSchedulingUtils.*;

import com.client.bu.project.cachedomain.servicedescriptor.Field;
import com.client.bu.project.cachedomain.servicedescriptor.FieldBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptorBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.StringType;

/**
 *
 * @author berenice.morales
 */
public class GetAlertDetailListByType extends ServiceDescriptorBuilder {

  public GetAlertDetailListByType() {
    name("getAlertDetailListByType")
    .description("")
    .urlPattern("")
    .filters(new Field[] {
        new FieldBuilder().name("type").type(StringType.class).build(),
        new FieldBuilder().name("general").type(StringType.class)
            .possibleValues(new String[] {"high", "medium", "low"}).build(),
        getTimeframeField(),
    })
    .parameters(new Field[] {
        new FieldBuilder().name("sortType")
            .possibleValues(new String[] {"severity", "lastUpdate", "pairing",})
            .type(StringType.class).build()})
    .returnType(getAlertDetailsCollectionType())
    .build();
  }
}
