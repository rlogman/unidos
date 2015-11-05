/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

import com.client.bu.project.cachedomain.servicedescriptor.CollectionBuilder;
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
 */
public class GetInflightDelayCodes extends ServiceDescriptorBuilder {

  public GetInflightDelayCodes() {
    this.name("getInflightDelayCodes");
    this.description("");
    this.urlPattern("");
    this.filters(new Field[] {new FieldBuilder().name("tbd").type(StringType.class).build(),});
    this.returnType(
        new CollectionBuilder().itemType(
            new ObjectBuilder().fields(
                new Field[] {
                    new FieldBuilder().name("flightLegId").type(StringType.class).build(),
                    new FieldBuilder().name("flightNumber").type(StringType.class).build(),
                    new FieldBuilder().name("fromAirport")
                        .type(CrewSchedulingUtils.getAirportType()).build(),
                    new FieldBuilder().name("toAirport").type(CrewSchedulingUtils.getAirportType())
                        .build(),
                    new FieldBuilder().name("delayInMinutes").type(Int32.class).build(),
                    new FieldBuilder().name("rsn").type(StringType.class).build(),
                    new FieldBuilder().name("tbd").type(StringType.class).build(),}).build())
            .build()).build();
  }
}
