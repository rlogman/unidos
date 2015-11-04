/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.bu.project.cachedomain.util;

import com.client.bu.project.cachedomain.servicedescriptor.BooleanType;
import com.client.bu.project.cachedomain.servicedescriptor.CollectionBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.CollectionType;
import com.client.bu.project.cachedomain.servicedescriptor.DateTimeType;
import com.client.bu.project.cachedomain.servicedescriptor.Field;
import com.client.bu.project.cachedomain.servicedescriptor.FieldBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.Int32;
import com.client.bu.project.cachedomain.servicedescriptor.ObjectBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.ObjectType;
import com.client.bu.project.cachedomain.servicedescriptor.StringType;
import com.client.bu.project.cachedomain.servicedescriptor.Type;

/**
 *
 * @author berenice.morales
 * @since 1.0
 * @version 1.0
 */
public class CrewSchedulingUtils {

    /**
     * 
     * @return 
     */
    public static CollectionType getPairingSummaryCollectionType() {
        return new CollectionBuilder().itemType(getPairingSummaryType()).build();
    }
    
    /**
     * 
     * @return 
     */
    public static ObjectType getPairingSummaryType() {
        return new ObjectBuilder().fields(
                new Field[]{
                    new FieldBuilder().name("pairingId")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("pairingCode")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("domicile")
                    .type(getDomicileType())
                    .build(),
                    new FieldBuilder().name("dhd")
                    .type(StringType.class) // FIXME find out what this is
                    .build(),
                    new FieldBuilder().name("status")
                    .type(StringType.class) // FIXME validate type
                    .possibleValues(new String[]{
                        "LH", "RSV"
                    })
                    .build(),
                    new FieldBuilder().name("crewMembers")
                    .type(getCrewMemberSummaryCollectionType())
                    .build(),
                    new FieldBuilder().name("alertType")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("lastUpdated")
                    .type(DateTimeType.UTC_TIMESTAMP_SECONDS)
                    .build(),}).build();
    }

    /**
     * 
     * @return 
     */
    public static Field[] getTimeframeAndTypeFieldArray() {
        return new Field[]{
            getTimeframeField(),
            new FieldBuilder()
            .name("type")
            .type(StringType.class)
            .possibleValues(
            new String[]{
                "severity",
                "type"})
            .build()};
    }
    
    /**
     * 
     * @return 
     */
    public static Field getTimeframeField() {
        return new FieldBuilder()
                .name("timeframe")
                .type(StringType.class)
                .possibleValues(
                        new String[]{"2h",
                            "6h", "8h",
                            "12h", "24h",
                            "36h", "48h",
                            "72h"})
                .build();
    }
    /**
     * 
     * @return 
     */
    public static CollectionType getPairingCollectionType() {
        return new CollectionBuilder().itemType(getPairingType()).build();
    }
    /**
     * 
     * @return 
     */
    public static ObjectType getPairingType() {
        return new ObjectBuilder().fields(
                new Field[]{
                    new FieldBuilder().name("pairingId")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("pairingCode")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("domicile")
                    .type(getDomicileType())
                    .build(),
                    new FieldBuilder().name("date")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("flightCount")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("pairingsCount")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("dutyPeriods")
                    .type(getDutyPeriodCollectionType())
                    .build(),
                    new FieldBuilder().name("crewMembers")
                    .type(getCrewMemberCollectionType())
                    .build(),
                    new FieldBuilder().name("flightLegs")
                    .type(getFlightLegCollectionType())
                    .build(),}).build();
    }
    /**
     * 
     * @return 
     */
    public static Type getDutyPeriodCollectionType() {
        return new CollectionBuilder().itemType(getDutyPeriodType()).build();
    }
    /**
     * 
     * @return 
     */
    public static Type getDutyPeriodType() {
        return new ObjectBuilder().fields(
                new Field[]{
                    new FieldBuilder().name("dutyPeriodId")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("crewMemberId")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("scheduledStartTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                    new FieldBuilder().name("scheduledEndTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                    new FieldBuilder().name("actualStartTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                    new FieldBuilder().name("actualEndTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                    new FieldBuilder().name("duties")
                    .type(getDutyCollectionType())
                    .build(),}).build();
    }
   
    /**
     * 
     * @return 
     */
    public static Type getDutyCollectionType() {
        return new CollectionBuilder().itemType(getDutyType()).build();
    }
    
    /**
     * 
     * @return 
     */
    public static Type getDutyType() {
        return new ObjectBuilder().fields(
                new Field[]{
                    new FieldBuilder().name("dutyId")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("dutyType")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("flightLegId")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("sequenceNumber")
                    .type(Int32.class)
                    .build(),
                    new FieldBuilder().name("deadHead")
                    .type(BooleanType.class)
                    .build(),
                    new FieldBuilder().name("scheduledStartTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                    new FieldBuilder().name("scheduledEndTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                    new FieldBuilder().name("actualStartTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                    new FieldBuilder().name("actualEndTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),}).build();
    }
    /**
     * 
     * @return 
     */
    public static Type getCrewMemberSummaryCollectionType() {
        return new CollectionBuilder().itemType(getCrewMemberSummaryType()).build();
    }
    
    /**
     * 
     * @return 
     */
    public static Type getCrewMemberSummaryType() {
        return new ObjectBuilder().fields(
                new Field[]{
                    new FieldBuilder().name("crewMemberId")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("firstName")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("lastName")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("class")
                    .type(StringType.class)
                    .possibleValues(new String[]{"Pilot", "FA"})
                    .build(),
                    new FieldBuilder().name("laborUnionCode")
                    .type(StringType.class)
                    .possibleValues(new String[]{"sUA", "sCO"})
                    .build(),
                    new FieldBuilder().name("seniority")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("domicileId")
                    .type(StringType.class)
                    .build(),}).build();

    }
    
    /**
     * 
     * @return 
     */
    public static Type getCrewMemberCollectionType() {
        return new CollectionBuilder().itemType(getCrewMemberType()).build();
    }
    
    /**
     * 
     * @return 
     */
    public static Type getCrewMemberType() {
        return new ObjectBuilder().fields(
                new Field[]{
                    new FieldBuilder().name("crewMemberId")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("firstName")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("lastName")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("class")
                    .type(StringType.class)
                    .possibleValues(new String[]{"Pilot", "FA"})
                    .build(),
                    new FieldBuilder().name("laborUnionCode")
                    .type(StringType.class)
                    .possibleValues(new String[]{"sUA", "sCO"})
                    .build(),}).build();

    }
 
    /**
     * 
     * @return 
     */
    public static Type getFlightLegCollectionType() {
        return new CollectionBuilder().itemType(getFlightLegType()).build();
    }

    /**
     * 
     * @return 
     */
    public static Type getFlightLegType() {
        return new ObjectBuilder().fields(
                new Field[]{
                    new FieldBuilder().name("flightLegId")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("fromAirport")
                    .type(getAirportType())
                    .build(),
                    new FieldBuilder().name("toAirport")
                    .type(getAirportType())
                    .build(),
                    new FieldBuilder().name("aircraft")
                    .type(getAircraftType())
                    .build(),
                    new FieldBuilder().name("flightNumber")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("scheduledDepartureTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                    new FieldBuilder().name("scheduledArrivalTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                    new FieldBuilder().name("actualDepartureTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),
                    new FieldBuilder().name("actualArrivalTimestamp")
                    .type(DateTimeType.UTC_TIMESTAMP_MINUTES)
                    .build(),}).build();
    }
     
    /**
     * 
     * @return 
     */
    public static Type getAircraftType() {
        return new ObjectBuilder().fields(
                new Field[]{
                    new FieldBuilder().name("aircraftId")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("type")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("tailNumber")
                    .type(StringType.class)
                    .build(),}).build();
    }
    
    /**
     * 
     * @return 
     */
    public static ObjectType getDomicileType() {
        return new ObjectBuilder().fields(
                new Field[]{
                    new FieldBuilder().name("domicileId")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("name")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("airports")
                    .type(new CollectionBuilder()
                            .itemType(getAirportType())
                            .build())
                    .build(),}).build();
    }
 
    /**
     * 
     * @return 
     */
    public static ObjectType getAirportType() {
        return new ObjectBuilder().fields(
                new Field[]{
                    new FieldBuilder().name("airportCode")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("locationCoarseAddress")
                    .type(getCoarseAddressType())
                    .build(),
                    new FieldBuilder().name("anchorCitiesCoarseAddress")
                    .type(getCoarseAddressCollectionType())
                    .build(),}).build();
    }
    
    /**
     * 
     * @return 
     */
    public static Type getCoarseAddressCollectionType() {
        return new CollectionBuilder().itemType(getCoarseAddressType()).build();
    }
    /**
     * 
     * @return 
     */
    public static ObjectType getCoarseAddressType() {
        return new ObjectBuilder().fields(
                new Field[]{
                    new FieldBuilder().name("city")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("stateOrProvince")
                    .type(StringType.class)
                    .build(),
                    new FieldBuilder().name("country")
                    .type(StringType.class)
                    .build(),}).build();
    }
    
    /**
     * 
     * @return 
     */
    public static CollectionType getWatchers() {
        return new CollectionBuilder().itemType(getPairingType()).build();
    }

	public static ObjectType getMasterScheduleFlightSegmentType() {
		return new ObjectBuilder().fields(new Field[] {
				new FieldBuilder().name("pair")
						.type(new CollectionBuilder().itemType(getMasterScheduleFlightSegmentType()).build())
						.build(),
				new FieldBuilder().name("scheduledStartTimestamp")
						.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
						.build(),
				new FieldBuilder().name("scheduledEndTimestamp")
						.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
						.build(),
				new FieldBuilder().name("estimatedStartTimestamp")
						.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
						.build(),
				new FieldBuilder().name("estimatedEndTimestamp")
						.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
						.build(),
				new FieldBuilder().name("actualStartTimestamp")
						.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
						.build(),
				new FieldBuilder().name("actualEndTimestamp")
						.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
						.build(),
				new FieldBuilder().name("flightSegments")
						.type(new CollectionBuilder().itemType(getMasterScheduleFlightSegmentType()).build())
						.build(),
				new FieldBuilder().name("flightSegments")
						.type(new CollectionBuilder().itemType(getMasterScheduleFlightSegmentType()).build())
						.build(),
				new FieldBuilder().name("flightSegments")
						.type(new CollectionBuilder().itemType(getMasterScheduleFlightSegmentType()).build())
						.build(),
				new FieldBuilder().name("flightSegments")
						.type(new CollectionBuilder().itemType(getMasterScheduleFlightSegmentType()).build())
						.build(),
		}).build();
	}

	public static ObjectType getMasterScheduleNonFlyingSegmentType() {
		return new ObjectBuilder().fields(new Field[] {
		// FIXME provide getMasterScheduleNonFlyingSegmentType details
				}).build();
	}

	public static ObjectType getMasterScheduleAlertType() {
		return new ObjectBuilder().fields(new Field[] {
		// FIXME provide getMasterScheduleAlertType details
				}).build();
	}
}

