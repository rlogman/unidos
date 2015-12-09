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

/**
 *
 * @author berenice.morales
 */
public class GetUnassignedInboundFAsReport extends ServiceDescriptorBuilder {

  public GetUnassignedInboundFAsReport() {
    name("getUnassignedInboundFAsReport")
    .description("https://jira.globant.com/browse/UCI321-120")
    .urlPattern("")
    .filters(new Field[] {
        new FieldBuilder().name("crewType").type(StringType.class)
            .possibleValues(new String[] {"Domestic", "International"}).build(),
        new FieldBuilder().name("startDate").type(DateTimeType.UTC_TIMESTAMP_MINUTES).build(),
        new FieldBuilder().name("finalDate").type(DateTimeType.UTC_TIMESTAMP_MINUTES).build(),
        new FieldBuilder()
            .name("stationList")
            .type(StringType.class)
            .build(),
    })
    .returnType(
        new ObjectBuilder().fields(
            new Field[] {new FieldBuilder().name("STA").type(StringType.class).build(),
                new FieldBuilder().name("FLT").type(StringType.class).build(),
                new FieldBuilder().name("DT").type(Int32.class).build(),
                new FieldBuilder().name("ARVL").type(DateTimeType.DURATION_MINUTES).build(),
                new FieldBuilder().name("DTM").type(DateTimeType.DURATION_MINUTES).build(),
                new FieldBuilder().name("ACM").type(DateTimeType.DURATION_MINUTES).build(),
                new FieldBuilder().name("ID").type(Int32.class).build(),
                new FieldBuilder().name("DT").type(Int32.class).build(),
                new FieldBuilder().name("DOM").type(StringType.class).build(),
                new FieldBuilder().name("POS").type(StringType.class).build(),}).build()).build();
  }
}
