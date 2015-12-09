package com.client.bu.project;

import java.io.IOException;

import com.client.bu.project.cachedomain.dashboard.GetInflightDelayCodesRequest;
import com.client.bu.project.cachedomain.dashboard.GetInflightDelayCodesResponse;
import com.client.bu.project.cachedomain.dashboard.GetPairingSummaryInformationRequest;
import com.client.bu.project.cachedomain.dashboard.GetPairingSummaryInformationResponse;
import com.client.bu.project.cachedomain.dashboard.GetPairingSummaryInformationResponseDetails;
import com.client.bu.project.cachedomain.dashboard.GetSummaryOfAlertsStatusRequest;
import com.client.bu.project.cachedomain.dashboard.GetSummaryOfAlertsStatusResponse;
import com.client.bu.project.cachedomain.dashboard.GetSummaryOfAlertsStatusResponseDetails;
import com.client.bu.project.cachedomain.profile.ChangeBaseSelectionRequest;
import com.client.bu.project.cachedomain.profile.ChangeBaseSelectionResponse;
import com.client.bu.project.cachedomain.profile.ChangeFleetSelectionRequest;
import com.client.bu.project.cachedomain.profile.ChangeFleetSelectionResponse;
import com.client.bu.project.cachedomain.profile.GetBaseSelectionRequest;
import com.client.bu.project.cachedomain.profile.GetBaseSelectionResponse;
import com.client.bu.project.cachedomain.profile.GetFleetSelectionRequest;
import com.client.bu.project.cachedomain.profile.GetFleetSelectionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;

public class GenerateJsonSchema {

  public static void main(String[] args) throws IOException {
    generateJsonSchema(new Class<?>[][] {
        {GetBaseSelectionRequest.class, GetBaseSelectionResponse.class},
        {GetFleetSelectionRequest.class, GetFleetSelectionResponse.class},
        {ChangeBaseSelectionRequest.class, ChangeBaseSelectionResponse.class},
        {ChangeFleetSelectionRequest.class, ChangeFleetSelectionResponse.class},
        {GetPairingSummaryInformationRequest.class, GetPairingSummaryInformationResponse.class,
            GetPairingSummaryInformationResponseDetails.class},
        {GetSummaryOfAlertsStatusRequest.class, GetSummaryOfAlertsStatusResponse.class,
            GetSummaryOfAlertsStatusResponseDetails.class},
        {GetInflightDelayCodesRequest.class, GetInflightDelayCodesResponse.class}});
  }

  private static void generateJsonSchema(Class<?>[][] classGroups) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();

    for (Class<?>[] classGroup : classGroups) {
      System.out.println("// =================================");
      for (Class<?> clazz : classGroup) {
        System.out.println("// ---------------------------------");
        System.out.println(getJsonSchema(mapper, visitor, clazz));
      }
    }
  }

  private static <T> String getJsonSchema(ObjectMapper mapper, SchemaFactoryWrapper visitor,
      Class<T> clazz) throws JsonProcessingException {
    mapper.acceptJsonFormatVisitor(clazz, visitor);
    JsonSchema schema = visitor.finalSchema();
    return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);
  }
}
