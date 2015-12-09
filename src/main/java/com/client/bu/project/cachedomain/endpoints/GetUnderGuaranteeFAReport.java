/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

import com.client.bu.project.cachedomain.servicedescriptor.CollectionBuilder;
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
 * @since 1.0
 * @version 1.0
 */
public class GetUnderGuaranteeFAReport extends ServiceDescriptorBuilder {

  public GetUnderGuaranteeFAReport() {
    name("getUnderGuaranteeFAReport")
    .description("https://jira.globant.com/browse/UCI321-120")
    .urlPattern("")
    .filters(new Field[] {
        new FieldBuilder().name("crewType").type(StringType.class)
            .possibleValues(new String[] {"domestic", "international"}).build(),
        new FieldBuilder().name("fromDateTime").type(DateTimeType.UTC_TIMESTAMP_MINUTES)
            .build(),
        new FieldBuilder().name("toDateTime").type(DateTimeType.UTC_TIMESTAMP_MINUTES)
            .build(), new FieldBuilder().name("domicile").type(StringType.class).build(),})
    .returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
        new FieldBuilder().name("sta").type(StringType.class).build(),
        new FieldBuilder().name("id").type(StringType.class).build(),
        new FieldBuilder().name("dt").type(Int32.class).build(),
        new FieldBuilder().name("pos").type(StringType.class).build(),
        new FieldBuilder().name("domicile").type(StringType.class).build(),
        new FieldBuilder().name("arrival").type(DateTimeType.UTC_TIMESTAMP_MINUTES).build(),
        new FieldBuilder().name("dt2").type(StringType.class).build(),
        new FieldBuilder().name("duty").type(DateTimeType.UTC_TIMESTAMP_MINUTES).build(),
        new FieldBuilder().name("lofGar").type(DateTimeType.UTC_TIMESTAMP_MINUTES).build(),
        new FieldBuilder().name("idGar").type(DateTimeType.UTC_TIMESTAMP_MINUTES).build(),
    }).build()).build());
  }
}
