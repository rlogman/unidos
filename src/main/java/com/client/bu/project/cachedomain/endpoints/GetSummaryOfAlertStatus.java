/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

import com.client.bu.project.cachedomain.servicedescriptor.CollectionBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.DoubleType;
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
public class GetSummaryOfAlertStatus extends ServiceDescriptorBuilder {

  public GetSummaryOfAlertStatus() {
    name("getSummaryOfAlertStatus")
    .description("https://jira.globant.com/browse/UCI321-13")
    .urlPattern("")
    .filters(CrewSchedulingUtils.getTimeframeAndTypeFieldArray())
    .returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
        new FieldBuilder().name("distributionPercentage").type(DoubleType.class).build(),
        new FieldBuilder().name("tbdAdditionalData").type(StringType.class).build(),})
    .build()).build());
  }
}
