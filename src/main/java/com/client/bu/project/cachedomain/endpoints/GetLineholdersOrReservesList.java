/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

import static com.client.bu.project.cachedomain.util.CrewSchedulingUtils.*;

import com.client.bu.project.cachedomain.servicedescriptor.CollectionBuilder;
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
public class GetLineholdersOrReservesList extends ServiceDescriptorBuilder {

  public GetLineholdersOrReservesList() {
    name("getLineHoldersOrReservesList")
    .description("")
    .urlPattern("")
    .filters(new Field[] {
        new FieldBuilder().name("dateFrom").type(DateTimeType.UTC_DATE).build(),
        new FieldBuilder().name("dateTo").type(DateTimeType.UTC_DATE).build(),
        new FieldBuilder().name("lineholderFlightArrivalTimeFrom")
            .type(DateTimeType.UTC_TIMESTAMP_MINUTES).build(),
        new FieldBuilder().name("lineholderFlightArrivalTimeTo")
            .type(DateTimeType.UTC_TIMESTAMP_MINUTES).build(),
        getCrewTypeField(),
        new FieldBuilder().name("positions").type(StringType.class) // TODO validate this type
            .build(),
        new FieldBuilder().name("fleetType").type(StringType.class) // TODO validate this type
            .build(),
        new FieldBuilder().name("lineholderFlightArrivalTimeTo").type(StringType.class)
            .possibleValues(new String[] {"lineholder", "reserve", "all"}).build(),
        new FieldBuilder().name("domicile").type(StringType.class).build(),
        new FieldBuilder().name("station").type(StringType.class).build(),})
    .parameters(new Field[] {
        new FieldBuilder()
            .name("sortBy")
            .type(StringType.class)
            .possibleValues(
                new String[] {"domicile", "pairingNumber", "lineholderBlockTime", "seniority",
                    "reserveStartDate", "reserveDaysAvailable", "reserveNextPairing"}).build(),})
    .returnType(new ObjectBuilder().fields(new Field[] {
        new FieldBuilder().name("totalResults").type(Int32.class).build(),
        new FieldBuilder()
            .name("lineholderData")
            .type(new ObjectBuilder().fields(new Field[] {
                new FieldBuilder().name("totalLineholderCount")
                    .type(Int32.class).build(),
                new FieldBuilder()
                    .name("lineholders")
                    .type(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
                        new FieldBuilder()
                            .name("domicile")
                            .type(getDomicileType())
                            .build(),
                        new FieldBuilder()
                            .name("employeeData")
                            .type(new ObjectBuilder().fields(new Field[] {
                                new FieldBuilder()
                                    .name("position")
                                    .type(StringType.class)
                                    .build(),
                                new FieldBuilder()
                                    .name("idNumber")
                                    .type(StringType.class)
                                    .build(),
                                new FieldBuilder()
                                    .name("firstName")
                                    .type(StringType.class)
                                    .build(),
                                new FieldBuilder()
                                    .name("lastName")
                                    .type(StringType.class)
                                    .build(),}).build())
                            .build(),
                        new FieldBuilder()
                            .name("pairingNumber")
                            .type(StringType.class)
                            .build(),
                        new FieldBuilder()
                            .name("seniority")
                            .type(StringType.class)
                            .build(),
                        new FieldBuilder()
                            .name("dutyDay")
                            .type(StringType.class) // FIXME provide right type
                            .build(),
                        new FieldBuilder()
                            .name("blockTime")
                            .type(DateTimeType.DURATION_MINUTES) // FIXME provide right type
                            .build(),
                        new FieldBuilder()
                            .name("nextFlightData")
                            .type(new ObjectBuilder().fields(new Field[] {
                                new FieldBuilder()
                                    .name("flightNumber")
                                    .type(StringType.class)
                                    .build(),
                                new FieldBuilder()
                                    .name("fromAirport")
                                    .type(CrewSchedulingUtils.getAirportType())
                                    .build(),
                                new FieldBuilder()
                                    .name("toAirport")
                                    .type(CrewSchedulingUtils.getAirportType())
                                    .build(),
                                new FieldBuilder()
                                    .name("scheduledDepartureTimestamp")
                                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                                    .build(),
                                new FieldBuilder()
                                    .name("estimatedDepartureTimestamp")
                                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                                    .build(),})
                        .build())
                            .build(),
                        new FieldBuilder()
                            .name("tbdLegalInfo")
                            .type(StringType.class) // FIXME define this
                            .build(),}).build())
                            .build()).build(),}).build()).build(),
        new FieldBuilder()
            .name("reservesData")
            .type(new ObjectBuilder().fields(new Field[] {
                new FieldBuilder().name("totalReserveCount")
                    .type(Int32.class).build(),
                new FieldBuilder()
                    .name("reserves")
                    .type(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
                        new FieldBuilder()
                            .name("domicile")
                            .type(getDomicileType())
                            .build(),
                        new FieldBuilder()
                            .name("inboundOrAtHome")
                            .type(StringType.class)
                            .possibleValues(
                                new String[] {
                                    "inbound",
                                    "atHome"})
                            .build(),
                        new FieldBuilder()
                            .name("employeeData")
                            .type(new ObjectBuilder().fields(new Field[] {
                                new FieldBuilder()
                                    .name("position")
                                    .type(StringType.class)
                                    .build(),
                                new FieldBuilder()
                                    .name("idNumber")
                                    .type(StringType.class)
                                    .build(),
                                new FieldBuilder()
                                    .name("firstName")
                                    .type(StringType.class)
                                    .build(),
                                new FieldBuilder()
                                    .name("lastName")
                                    .type(StringType.class)
                                    .build(),
                             }).build())
                            .build(),
                        new FieldBuilder()
                            .name("pairingNumber")
                            .type(StringType.class)
                            .build(),
                        new FieldBuilder()
                            .name(
                                "nextPairingNumber")
                            .type(StringType.class)
                            .build(),
                        new FieldBuilder()
                            .name("typeOfReserve")
                            .type(StringType.class)
                            .build(),
                        new FieldBuilder()
                            .name("seniority")
                            .type(StringType.class)
                            .build(),
                        new FieldBuilder()
                            .name("startDate")
                            .type(
                                DateTimeType.UTC_DATE)
                            .build(),
                        new FieldBuilder()
                            .name("startTime")
                            .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                            .build(),
                        new FieldBuilder()
                            .name("daysAvailable")
                            .type(Int32.class)
                            .build(),
                        new FieldBuilder()
                            .name("tbdLegalInfo")
                            .type(StringType.class) // FIXME define this
                            .build(),}).build())
                            .build()).build(),}).build()).build(),})
            .build());
  }
}
