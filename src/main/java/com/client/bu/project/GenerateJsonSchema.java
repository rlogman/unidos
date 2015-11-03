package com.client.bu.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.client.bu.project.cachedomain.servicedescriptor.BooleanType;
import com.client.bu.project.cachedomain.servicedescriptor.CollectionBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.CollectionType;
import com.client.bu.project.cachedomain.servicedescriptor.DateTimeType;
import com.client.bu.project.cachedomain.servicedescriptor.DecimalType;
import com.client.bu.project.cachedomain.servicedescriptor.DoubleType;
import com.client.bu.project.cachedomain.servicedescriptor.Field;
import com.client.bu.project.cachedomain.servicedescriptor.FieldBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.Int32;
import com.client.bu.project.cachedomain.servicedescriptor.ObjectBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.ObjectType;
import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptor;
import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptorBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.StringType;
import com.client.bu.project.cachedomain.servicedescriptor.Type;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;

public class GenerateJsonSchema {

	public static void main(String[] args) throws IOException {
		generateJsonSchema(new Class<?>[][] {
				{ GetBaseSelectionRequest.class, GetBaseSelectionResponse.class },
				{ GetFleetSelectionRequest.class,
						GetFleetSelectionResponse.class },
				{ ChangeBaseSelectionRequest.class,
						ChangeBaseSelectionResponse.class },
				{ ChangeFleetSelectionRequest.class,
						ChangeFleetSelectionResponse.class },
				{ GetPairingSummaryInformationRequest.class,
						GetPairingSummaryInformationResponse.class,
						GetPairingSummaryInformationResponseDetails.class },
				{ GetSummaryOfAlertsStatusRequest.class,
						GetSummaryOfAlertsStatusResponse.class,
						GetSummaryOfAlertsStatusResponseDetails.class },
				{ GetInflightDelayCodesRequest.class,
						GetInflightDelayCodesResponse.class } });
		List<ServiceDescriptor> endpoints = buildEndpointList();
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		System.out.println("// **************************");
		System.out.println("// **************************");
		System.out.println("// **************************");
		System.out.println("// **************************");
		System.out.println("// **************************");
		System.out.println(mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(endpoints));
	}

	private static List<ServiceDescriptor> buildEndpointList() {
		List<ServiceDescriptor> endpoints = new ArrayList<ServiceDescriptor>();
		endpoints.add(new ServiceDescriptorBuilder()
				.name("getBaseSelection")
				.description("")
				.urlPattern("")
				.parameters(
						new Field[] {
								new FieldBuilder().name("profile")
										.type(StringType.class).build(),
								new FieldBuilder().name("tbdOther")
										.type(StringType.class).build() })
				.returnType(StringType.class).build());
		endpoints.add(new ServiceDescriptorBuilder()
				.name("getFleetSelection")
				.description("")
				.urlPattern("")
				.parameters(
						new Field[] {
								new FieldBuilder().name("profile")
										.type(StringType.class).build(),
								new FieldBuilder().name("tbdOther")
										.type(StringType.class).build() })
				.returnType(new StringType()).build());
		endpoints
				.add(new ServiceDescriptorBuilder()
						.name("changeBaseSelection")
						.description("")
						.urlPattern("")
						.parameters(
								new Field[] {
										new FieldBuilder().name("selection")
												.type(StringType.class).build(),
										new FieldBuilder().name("type")
												.type(StringType.class).build(),
										new FieldBuilder().name("userid")
												.type(StringType.class).build() })
						.returnType(
								new ObjectBuilder().fields(
										new Field[] {
												new FieldBuilder()
														.name("tbdOther")
														.type(StringType.class)
														.build() }).build())
						.build());
		endpoints.add(new ServiceDescriptorBuilder()
				.name("changeFleetSelection")
				.description("")
				.urlPattern("")
				.parameters(
						new Field[] {
								new FieldBuilder().name("selection")
										.type(StringType.class).build(),
								new FieldBuilder().name("type")
										.type(StringType.class).build(),
								new FieldBuilder().name("userid")
										.type(StringType.class).build() })
				.returnType(
						new ObjectBuilder().fields(
								new Field[] {
										new FieldBuilder()
												.name("tbdOther")
												.type(StringType.class)
												.build() }).build())
				.build());
		endpoints.add(new ServiceDescriptorBuilder()
				.name("getPairingSummaryInformation")
				.description("")
				.urlPattern("")
				.parameters(getTimeframeAndTypeFieldArray())
				.returnType(new ObjectBuilder().fields(new Field[] {
						new FieldBuilder().name("affectedPairings")
								.type(getPairingCollectionType())
								.build(),
						new FieldBuilder().name("alertCount")
								.type(StringType.class)
								.build(),
						new FieldBuilder().name("date")
								.type(DateTimeType.UTC_DATE)
								.build(),
						new FieldBuilder().name("flightCount")
								.type(StringType.class)
								.build(),
						new FieldBuilder().name("openPairings")
								.type(getPairingCollectionType())
								.build(),
						new FieldBuilder().name("pairingsCount")
								.type(StringType.class)
								.build(),
						new FieldBuilder().name("scheduledPairings")
								.type(getPairingCollectionType())
								.build(),
				}).build())
		.build());
		endpoints.add(new ServiceDescriptorBuilder()
				.name("getSummaryOfAlertStatus")
				.description("")
				.urlPattern("")
				.parameters(getTimeframeAndTypeFieldArray())
				.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
						new FieldBuilder()
								.name("distributionPercentage")
								.type(DoubleType.class)
								.build(),
						new FieldBuilder()
								.name("tbdAdditionalData")
								.type(StringType.class)
								.build(),
				}).build()).build())
				.build());
		endpoints.add(new ServiceDescriptorBuilder()
				.name("getInflghtDelayCodes")
				.description("")
				.urlPattern("")
				.parameters(new Field[] {
						new FieldBuilder().name("tbd")
								.type(StringType.class).build(),
				})
				.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
						new FieldBuilder().name("flightLegId")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("flightNumber")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("fromAirport")
								.type(getAirportType())
								.build(),
						new FieldBuilder()
								.name("toAirport")
								.type(getAirportType())
								.build(),
						new FieldBuilder()
								.name("delayInMinutes")
								.type(Int32.class)
								.build(),
						new FieldBuilder()
								.name("rsn")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("tbd")
								.type(StringType.class)
								.build(),
				}).build()).build())
				.build());
		endpoints.add(new ServiceDescriptorBuilder()
				.name("local.getHyperLinks")
				.description("")
				.urlPattern("")
				.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
						new FieldBuilder().name("name")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("description")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("accessLink")
								.type(StringType.class)
								.build(),
				}).build()).build())
				.build());
//		endpoints.add(new ServiceDescriptorBuilder()
//				.name("getTripsCoverage")
//				.description("")
//				.urlPattern("")
//				.parameters(new Field[] {
//						new FieldBuilder().name("tbd")
//								.type(StringType.class).build(),
//				})
//				.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
//						new FieldBuilder().name("reserves")
//								.description("Number of available reserves")
//								.type(Int32.class)
//								.build(),
//						new FieldBuilder()
//								.name("openTrips") // TO-DO verify if its data type is correct
//								.type(Int32.class)
//								.build(),
//						new FieldBuilder()
//								.name("crewAvailable")
//								.type(StringType.class) // TO-DO verify if this data type is correct
//								.build(),
//				}).build()).build())
//				.build());
		endpoints.add(new ServiceDescriptorBuilder()
				.name("local.getProfileAvailableReports")
				.description("")
				.urlPattern("")
				.parameters(new Field[] {
						new FieldBuilder().name("profileId")
								.type(StringType.class).build(),
				})
				.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
								new FieldBuilder().name("name")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("description")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("accessLink")
								.type(StringType.class)
								.build(),
				}).build()).build())
				.build());
		endpoints.add(new ServiceDescriptorBuilder()
				.name("local.getAlertManagementDashboard")
				.description("")
				.urlPattern("")
				.parameters(new Field[] {
						new FieldBuilder().name("profileId") // TODO double-check this; it seems invalid
								.type(StringType.class).build(),
				})
				.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] { // TODO double-check whole return; it seems invalid
								new FieldBuilder().name("name")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("description")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("accessLink")
								.type(StringType.class)
								.build(),
				}).build()).build())
				.build());
		endpoints.add(new ServiceDescriptorBuilder()
				.name("getScheduleSummaryInformation")
				.description("")
				.urlPattern("")
				.parameters(new Field[] {// TODO double-check this
				})
				.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
								new FieldBuilder().name("date")
								.type(DateTimeType.UTC_DATE)
								.build(),
						new FieldBuilder()
								.name("totalPairings")
								.type(Int32.class)
								.build(),
						new FieldBuilder()
								.name("totalFlights")
								.type(Int32.class)
								.build(),
						new FieldBuilder()
								.name("scheduledAlertsCount")
								.type(Int32.class)
								.build(),
						new FieldBuilder()
								.name("irropAlertsCount")
								.type(Int32.class)
								.build(),
						new FieldBuilder()
								.name("openAlertsCount")
								.type(Int32.class)
								.build(),
						new FieldBuilder()
								.name("totalAlertsCount")
								.type(Int32.class)
								.build(),
						new FieldBuilder()
								.name("totalsByAlertType")
								.type(new ObjectBuilder().fields(new Field[] {
										new FieldBuilder()
												.name("block")
												.type(Int32.class)
												.build(),
										new FieldBuilder()
												.name("duty")
												.type(Int32.class)
												.build(),
										new FieldBuilder()
												.name("farStaffing")
												.type(Int32.class)
												.build(),
										new FieldBuilder()
												.name("farCrewRest")
												.type(Int32.class)
												.build(),
										new FieldBuilder()
												.name("farQualifications")
												.type(Int32.class)
												.build(),
										new FieldBuilder()
												.name("farEntryDocumentation")
												.type(Int32.class)
												.build(),
										new FieldBuilder()
												.name("cancellation")
												.type(Int32.class)
												.build(),
										new FieldBuilder()
												.name("delay")
												.type(Int32.class)
												.build(),
										new FieldBuilder()
												.name("missconnection")
												.type(Int32.class)
												.build(),
										new FieldBuilder()
												.name("crewRestContract")
												.type(Int32.class)
												.build(),
										new FieldBuilder()
												.name("taxi")
												.type(Int32.class)
												.build(),
										new FieldBuilder()
												.name("uaStaffing")
												.type(Int32.class)
												.build(),
										new FieldBuilder()
												.name("unassignedInbound")
												.type(Int32.class)
												.build(),
										new FieldBuilder()
												.name("flightOnTime")
												.type(Int32.class)
												.build(),
								}).build())
								.build(),
				}).build()).build())
				.build());
		endpoints.add(new ServiceDescriptorBuilder()
			.name("getAlertsTailView")
			.description("")
			.urlPattern("")
			.parameters(new Field[] {
					getTimeframeField(),
					new FieldBuilder().name("sortType")
							.possibleValues(new String[] {
									"tailNumber",
									"scheduledDepartureTime",
									"estimatedDepartureTime",
									"actualDepartureTime",
									"scheduledArrivalTime",
									"estimatedArrivalTime",
									"actualArrivaleTime",
									"highestSeverityFirst",
							})
							.type(StringType.class).build(),
			})
			.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
					new FieldBuilder()
						.name("tailNumber")
						.type(StringType.class)
						.build(),
					new FieldBuilder().name("fromAirport")
							.type(getAirportType())
							.build(),
					new FieldBuilder().name("toAirport")
							.type(getAirportType())
							.build(),
					new FieldBuilder()
							.name("severityIndicator")
							.type(StringType.class)
							.build(),
					new FieldBuilder()
							.name("alertTypeCategory")
							.type(StringType.class)
							.build(),
					new FieldBuilder()
							.name("alertTypeSubCategory")
							.type(StringType.class)
							.build(),
					new FieldBuilder()
							.name("local.assignedIndicator")
							.type(BooleanType.class)
							.build(),
					new FieldBuilder()
							.name("local.watchedByMeIndicator")
							.type(BooleanType.class)
							.build(),
			}).build()).build())
			.build());
		endpoints.add(new ServiceDescriptorBuilder()
				.name("getAlertsFlightView")
				.description("")
				.urlPattern("")
				.parameters(new Field[] {
						getTimeframeField(),
						new FieldBuilder()
								.name("sortType")
								.type(StringType.class)
								.possibleValues(new String[] {
										"flightNumber",
										"scheduledDepartureTime",
										"estimatedDepartureTime",
										"actualDepartureTime",
										"scheduledArrivalTime",
										"estimatedArrivalTime",
										"actualArrivaleTime",
										"highestSeverityFirst",
								})
								.build(),
				})
				.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
						new FieldBuilder()
							.name("flightNumber")
							.type(StringType.class)
							.build(),
						new FieldBuilder().name("fromAirport")
								.type(getAirportType())
								.build(),
						new FieldBuilder().name("toAirport")
								.type(getAirportType())
								.build(),
						new FieldBuilder()
								.name("severityIndicator")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("alertTypeCategory")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("alertTypeSubCategory")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("local.assignedIndicator")
								.type(BooleanType.class)
								.build(),
						new FieldBuilder()
								.name("local.watchedByMeIndicator")
								.type(BooleanType.class)
								.build(),
				}).build()).build())
				.build());
		endpoints.add(new ServiceDescriptorBuilder()
				.name("getAlertsCrewView")
				.description("")
				.urlPattern("")
				.parameters(new Field[] {
						getTimeframeField(),
						new FieldBuilder()
								.name("sortType")
								.type(StringType.class)
								.possibleValues(new String[] {
										"fileNumber",
										"departureTime",
										"arrivalTime",
										"seniority",
										"alertAssignment",
										"severity",
										"domicile",
								})
								.build(),
				})
				.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
						new FieldBuilder()
							.name("flightNumber")
							.type(StringType.class)
							.build(),
						new FieldBuilder().name("fromAirport")
								.type(getAirportType())
								.build(),
						new FieldBuilder().name("toAirport")
								.type(getAirportType())
								.build(),
						new FieldBuilder()
								.name("severityIndicator")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("alertTypeCategory")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("alertTypeSubCategory")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("local.assignedIndicator")
								.type(BooleanType.class)
								.build(),
						new FieldBuilder()
								.name("local.watchedByMeIndicator")
								.type(BooleanType.class)
								.build(),
				}).build()).build())
				.build());
		endpoints.add(new ServiceDescriptorBuilder()
				.name("getAlertPreviewInformation")
				.description("")
				.urlPattern("")
				.parameters(new Field[] {
						new FieldBuilder()
								.name("alertId")
								.type(StringType.class)
								.build(),
				})
				.returnType(new ObjectBuilder().fields(new Field[] {	
						new FieldBuilder()
								.name("severity")
								.type(StringType.class)
								.build(),
						new FieldBuilder().name("otherAlertsAffectingThisSameFlight")
								.type(Int32.class) 	// FIXME Validate type
								.build(),
						new FieldBuilder().name("watchersCount")
								.type(Int32.class)
								.build(),
						new FieldBuilder()
								.name("assignedIndicator")
								.type(StringType.class)  // FIXME validate type
								.build(),
						new FieldBuilder()
								.name("pairingId")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("affectedFACount")
								.type(Int32.class)
								.build(),
						new FieldBuilder()
								.name("affectedPilotsCount")
								.type(Int32.class)
								.build(),
						new FieldBuilder()
								.name("lastUpdated")
								.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
								.build(),
						new FieldBuilder()
								.name("flightNumber")
								.type(StringType.class)
								.build(),
						new FieldBuilder().name("fromAirport")
								.type(getAirportType())
								.build(),
						new FieldBuilder().name("toAirport")
								.type(getAirportType())
								.build(),
						new FieldBuilder()
								.name("date")
								.type(DateTimeType.UTC_DATE)
								.build(),
						new FieldBuilder()
								.name("pairingId")
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
								.build(),
				}).build())
				.build());
		endpoints.add(new ServiceDescriptorBuilder()
				.name("local.getTimezones")
				.description("")
				.urlPattern("")
				.parameters(new Field[] {
				})
				.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
						new FieldBuilder()
								.name("name")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("abbreviation")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("utcOffset")
								.type(DecimalType.class)
								.build(),
						new FieldBuilder()
								.name("isDefault")
								.type(BooleanType.class)
								.build(),
				}).build()).build())
				.build());
		// FIXME add filter-related endpoints
		// FIXME add "general" section endpoints
		// FIXME add comments section endpoints
		
		endpoints.add(new ServiceDescriptorBuilder()
				.name("getFlightInformation")
				.description("")
				.urlPattern("")
				.parameters(new Field[] {
						new FieldBuilder()
						.name("flightNumber")
						.type(StringType.class)
						.build(),
				})
				.returnType(new ObjectBuilder().fields(new Field[] {
						new FieldBuilder()
								.name("flightNumber")
								.type(StringType.class)
								.build(),
						new FieldBuilder().name("fromAirport")
								.type(getAirportType())
								.build(),
						new FieldBuilder().name("toAirport")
								.type(getAirportType())
								.build(),
						new FieldBuilder()
								.name("status")
								.type(new ObjectBuilder().fields(new Field[] {
										new FieldBuilder()
												.name("onTime")
												.type(BooleanType.class)
												.build(),
										new FieldBuilder()
												.name("missconnected")
												.type(BooleanType.class)
												.build(),
										new FieldBuilder()
												.name("delayed")
												.type(BooleanType.class)
												.build(),
										new FieldBuilder()
												.name("inMaintenance")
												.type(BooleanType.class)
												.build(),
										new FieldBuilder()
												.name("canceled")
												.type(BooleanType.class)
												.build(),
										new FieldBuilder()
												.name("inProgress")
												.type(BooleanType.class)
												.build(),
										new FieldBuilder()
												.name("decision")
												.type(StringType.class)
												.possibleValues(new String[] {
														"pending-delay",
														"pending-on-time"
												})
												.build(),
								}).build())
								.build(),
						new FieldBuilder().name("scheduledDepartureTimestamp")
								.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
								.build(),
						new FieldBuilder().name("scheduledArrivalTimestamp")
								.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
								.build(),
						new FieldBuilder().name("estimatedDepartureTimestamp")
								.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
								.build(),
						new FieldBuilder().name("estimatedArrivalTimestamp")
								.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
								.build(),
						new FieldBuilder().name("actualDepartureTimestamp")
								.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
								.build(),
						new FieldBuilder().name("actualArrivalTimestamp")
								.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
								.build(),
						new FieldBuilder().name("scheduledFlightTime")
								.type(DateTimeType.DURATION_MINUTES)
								.build(),
						new FieldBuilder().name("fdpCco")
								.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
								.build(),
						new FieldBuilder().name("blkCco")
								.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
								.build(),
						new FieldBuilder().name("bmt")
								.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
								.build(),
						new FieldBuilder().name("taxiIn")
								.type(DateTimeType.DURATION_MINUTES)
								.build(),
						new FieldBuilder()
								.name("dispatcher")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("departureGate")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("arrivalGate")
								.type(StringType.class)
								.build(),
						new FieldBuilder().name("flightHistory")
								.type(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
										new FieldBuilder()
												.name("kind")
												.type(StringType.class)
												.possibleValues(new String[] {
														"arrival_time",
														"departure_time",
														"pairings"
												}).build(),
										new FieldBuilder().name("timestamp")
												.type(DateTimeType.UTC_TIMESTAMP_SECONDS)
												.build(),
										new FieldBuilder().name("local.who")
												.type(StringType.class)
												.build(),
										new FieldBuilder().name("local.comments")
												.type(StringType.class)
												.build(),
										
								}).build()).build())
								.build(),
						new FieldBuilder().name("associatedPairings")
								.type(getPairingSummaryCollectionType())
								.build(),
				}).build())
				.build());
		// TODO add endpoints to support comments at flight level
		endpoints.add(new ServiceDescriptorBuilder()
				.name("getPairingInformation")
				.description("")
				.urlPattern("")
				.parameters(new Field[] {	// TODO validate parameters
				})
				.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
						new FieldBuilder()
								.name("pairingNumber")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("dayCount")
								.type(Int32.class)
								.build(),
						new FieldBuilder()
								.name("segmentCount")
								.type(Int32.class)
								.build(),
						new FieldBuilder()
								.name("flightDuration")
								.type(DateTimeType.DURATION_MINUTES)
								.build(),
						new FieldBuilder()
								.name("flightDuration2")	// TODO clarify why there are 2 times
								.type(DateTimeType.DURATION_MINUTES)
								.build(),
						new FieldBuilder()
								.name("layoverCities")
								.type(new CollectionBuilder().itemType(StringType.class).build())  // TODO decide whether this is a string or an airport object
								.build(),
						new FieldBuilder()
								.name("hoursAwayCount")
								.type(DateTimeType.DURATION_HOURS)
								.build(),
						new FieldBuilder()
								.name("dhdTime")
								.type(DateTimeType.DURATION_MINUTES)
								.build(),
						new FieldBuilder()
								.name("guaranteedTime")
								.type(DateTimeType.DURATION_MINUTES)
								.build(),
						new FieldBuilder()
								.name("guaranteedTime2")	// TODO clarify why there are 2 times
								.type(DateTimeType.DURATION_MINUTES)
								.build(),
						new FieldBuilder()
								.name("payTimeInHours")
								.type(DateTimeType.DURATION_HOURS)
								.build(),
						new FieldBuilder()
								.name("dutyPeriods")
								.type(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
										new FieldBuilder()
												.name("reportTime")
												.type(DateTimeType.DURATION_MINUTES)
												.build(),
										new FieldBuilder()
												.name("debriefTime")
												.type(DateTimeType.DURATION_MINUTES)
												.build(),
										new FieldBuilder()
												.name("scheduledDutyTime")
												.type(DateTimeType.DURATION_MINUTES)
												.build(),
										new FieldBuilder()
												.name("actualDutyTime")
												.type(DateTimeType.DURATION_MINUTES)
												.build(),
										new FieldBuilder()
												.name("scheduledFlightTime")
												.type(DateTimeType.DURATION_MINUTES)
												.build(),
										new FieldBuilder()
												.name("actualFlightTime")
												.type(DateTimeType.DURATION_MINUTES)
												.build(),
										new FieldBuilder()
												.name("flightNumber")
												.type(StringType.class)
												.build(),
										new FieldBuilder().name("fromAirport")
												.type(getAirportType())
												.build(),
										new FieldBuilder().name("toAirport")
												.type(getAirportType())
												.build(),
										new FieldBuilder()
												.name("status")
												.type(new ObjectBuilder().fields(new Field[] {
														new FieldBuilder()
																.name("onTime")
																.type(BooleanType.class)
																.build(),
														new FieldBuilder()
																.name("missconnected")
																.type(BooleanType.class)
																.build(),
														new FieldBuilder()
																.name("delayed")
																.type(BooleanType.class)
																.build(),
														new FieldBuilder()
																.name("inMaintenance")
																.type(BooleanType.class)
																.build(),
														new FieldBuilder()
																.name("canceled")
																.type(BooleanType.class)
																.build(),
														new FieldBuilder()
																.name("inProgress")
																.type(BooleanType.class)
																.build(),
												}).build())
												.build(),
										new FieldBuilder().name("scheduledDepartureTimestamp")
												.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
												.build(),
										new FieldBuilder().name("scheduledArrivalTimestamp")
												.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
												.build(),
										new FieldBuilder().name("estimatedDepartureTimestamp")
												.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
												.build(),
										new FieldBuilder().name("estimatedArrivalTimestamp")
												.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
												.build(),
										new FieldBuilder().name("scheduledFlightTime")
												.type(DateTimeType.DURATION_MINUTES)
												.build(),
										new FieldBuilder()
												.name("dispatcher")
												.type(StringType.class)
												.build(),
										new FieldBuilder()
												.name("departureGate")
												.type(StringType.class)
												.build(),
										new FieldBuilder()
												.name("arrivalGate")
												.type(StringType.class)
												.build(),
										new FieldBuilder()
												.name("extraFlightInformation")
												.type(new ObjectBuilder().fields(new Field[] {
														new FieldBuilder()
																.name("lastUpdated")
																.type(DateTimeType.UTC_TIMESTAMP_SECONDS)
																.build(),
														new FieldBuilder()
																.name("noseNumber")
																.type(StringType.class)
																.build(),
														new FieldBuilder()
																.name("capacity")
																.type(Int32.class)
																.build(),
														new FieldBuilder()
																.name("plannedSeatsPerCategory")
																.type(new ObjectBuilder().fields(new Field[] {
																		new FieldBuilder()
																				.name("category")
																				.type(StringType.class)
																				.build(),
																		new FieldBuilder()
																				.name("seatCount")
																				.type(Int32.class)
																				.build(),
																}).build())
																.build(),
														new FieldBuilder()
																.name("crewMeal")
																.type(new ObjectBuilder().fields(new Field[] {
																		new FieldBuilder()
																				.name("mealType")
																				.type(StringType.class)
																				.possibleValues(new String[] {
																						"Breakfast",
																						"Lunch",
																						"Dinner",
																						"Other"	// TODO validate these values
																				})
																				.build(),
																		new FieldBuilder()
																				.name("mealDescription")
																				.type(Int32.class)
																				.build(),
																}).build())
																.build(),
												}).build())
												.build(),
								}).build()).build())
								.build(),
						new FieldBuilder()
								.name("sitTime")
								.type(DateTimeType.DURATION_MINUTES)
								.build(),
						new FieldBuilder()
								.name("layoverTime")
								.type(new ObjectBuilder().fields(new Field[] {
										new FieldBuilder()
												.name("time")
												.type(DateTimeType.DURATION_MINUTES)
												.build(),
										new FieldBuilder()
												.name("station")
												.type(getAirportType())
												.build(),
										new FieldBuilder()
												.name("toHotelTransportation")
												.type(getTransportationType())
												.build(),
										new FieldBuilder()
												.name("hotel")
												.type(getHotelType())
												.build(),
										new FieldBuilder()
												.name("toAirportTransportation")
												.type(getTransportationType())
												.build(),
								}).build())
								.build(),
						new FieldBuilder()
								.name("crewInformation")
								.type(getCrewInformationCollectionType())
								.build(),
				}).build()).build())
				.build());
		endpoints.add(new ServiceDescriptorBuilder()
				.name("getMasterScheduleList")
				.description("")
				.urlPattern("")
				.parameters(new Field[] {	// TODO Validate
				})
				.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
						new FieldBuilder()
								.name("id")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("position")
								.type(StringType.class)
								.possibleValues(new String[] {
										// FIXME provide possible values
								})
								.build(),
						new FieldBuilder()
								.name("firstName")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("lastName")
								.type(StringType.class)
								.build(),
						new FieldBuilder().name("domicile")
								.type(getDomicileType())
								.build(),
						new FieldBuilder()
								.name("cellPhone")
								.type(StringType.class)
								.build(),
						new FieldBuilder()
								.name("alertsAssociated")
								.type(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
										new FieldBuilder().name("severity")
												.type(StringType.class)
												.possibleValues(new String[] {
														// FIXME provide possible values
												})
												.build(),
										new FieldBuilder().name("type")
												.type(StringType.class)
												.possibleValues(new String[] {
														// FIXME provide possible values
												})
												.build(),
										new FieldBuilder().name("pairingsAffected")	// TODO is this an enumeration or a count?
												.type(new CollectionBuilder().itemType(StringType.class).build())	// TODO Validate
												.build(),
										new FieldBuilder().name("pilotsAffectedCount")
												.type(Int32.class)
												.build(),
										new FieldBuilder()
												.name("affectedFACount")
												.type(Int32.class)
												.build(),
										new FieldBuilder()
												.name("affectedPilotsCount")
												.type(Int32.class)
												.build(),
								})
								.build()).build())
								.build(),
						new FieldBuilder()
								.name("lastUpdate")
								.type(DateTimeType.UTC_TIMESTAMP_SECONDS)
								.build(),
				}).build()).build())
				.build());
		return endpoints;
	}

	private static Type getTransportationType() {
		return new ObjectBuilder().fields(new Field[] {
				new FieldBuilder().name("companyName")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("pickupTime")
						.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
						.build(),
				new FieldBuilder().name("pickupLocation")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("phone")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("voucherNumber")
						.type(StringType.class)
						.build(),
		}).build();
	}

	private static Type getHotelType() {
		return new ObjectBuilder().fields(new Field[] {
				new FieldBuilder().name("name")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("address")
						.type(getAddressType())
						.build(),
				new FieldBuilder().name("phone")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("reservationNumber")
						.type(StringType.class)
						.build(),
		}).build();
	}

	private static Type getAddressType() {
		return new ObjectBuilder().fields(new Field[] {
				new FieldBuilder().name("address1")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("address2")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("city")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("stateOrProvince")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("postalCode")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("country")
						.type(StringType.class)
						.build(),
		}).build();
	}

	private static CollectionType getCrewInformationCollectionType() {
		return new CollectionBuilder().itemType(getCrewInformationType()).build();
	}

	private static Type getCrewInformationType() {
		return new ObjectBuilder().fields(new Field[] {
				new FieldBuilder().name("id")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("photoUrl")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("firstName")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("lastName")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("position")
						.type(StringType.class)	// TODO clarify/validate this
						.build(),
				new FieldBuilder().name("last3Landings")
						.type(new CollectionBuilder().itemType(DateTimeType.UTC_TIMESTAMP_MINUTES).build())
						.build(),
				new FieldBuilder().name("nextExpirationDate")
						.type(DateTimeType.UTC_DATE)
						.build(),
		}).build();
	}

	private static CollectionType getPairingSummaryCollectionType() {
		return new CollectionBuilder().itemType(getPairingSummaryType()).build();
	}

	private static ObjectType getPairingSummaryType() {
		return new ObjectBuilder().fields(
				new Field[] {
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
						.type(StringType.class)		// FIXME find out what this is
						.build(),
						new FieldBuilder().name("status")
						.type(StringType.class)		// FIXME validate type
						.possibleValues(new String[] {
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
						.build(),
				}).build();
	}

	private static Field[] getTimeframeAndTypeFieldArray() {
		return new Field[] {
				getTimeframeField(),
				new FieldBuilder()
						.name("type")
						.type(StringType.class)
						.possibleValues(
								new String[] {
										"severity",
										"type" })
						.build() };
	}

	private static Field getTimeframeField() {
		return new FieldBuilder()
				.name("timeframe")
				.type(StringType.class)
				.possibleValues(
						new String[] { "2h",
								"6h", "8h",
								"12h", "24h",
								"36h", "48h",
								"72h" })
				.build();
	}

	private static CollectionType getPairingCollectionType() {
		return new CollectionBuilder().itemType(getPairingType()).build();
	}

	private static ObjectType getPairingType() {
		return new ObjectBuilder().fields(
				new Field[] {
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
						.build(),
				}).build();
	}

	private static Type getDutyPeriodCollectionType() {
		return new CollectionBuilder().itemType(getDutyPeriodType()).build();
	}

	private static Type getDutyPeriodType() {
		return new ObjectBuilder().fields(
				new Field[] {
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
						.build(),
				}).build();
	}

	private static Type getDutyCollectionType() {
		return new CollectionBuilder().itemType(getDutyType()).build();
	}

	private static Type getDutyType() {
		return new ObjectBuilder().fields(
				new Field[] {
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
						.build(),
				}).build();
	}

	private static Type getCrewMemberSummaryCollectionType() {
		return new CollectionBuilder().itemType(getCrewMemberSummaryType()).build();
	}

	private static Type getCrewMemberSummaryType() {
		return new ObjectBuilder().fields(
				new Field[] {
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
						.possibleValues(new String[] { "Pilot", "FA"})
						.build(),
						new FieldBuilder().name("laborUnionCode")
						.type(StringType.class)
						.possibleValues(new String[] { "sUA", "sCO"})
						.build(),
						new FieldBuilder().name("seniority")
						.type(StringType.class)
						.build(),
						new FieldBuilder().name("domicileId")
						.type(StringType.class)
						.build(),
				}).build();
	}

	private static Type getCrewMemberCollectionType() {
		return new CollectionBuilder().itemType(getCrewMemberType()).build();
	}

	private static Type getCrewMemberType() {
		return new ObjectBuilder().fields(
				new Field[] {
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
						.possibleValues(new String[] { "Pilot", "FA"})
						.build(),
						new FieldBuilder().name("laborUnionCode")
						.type(StringType.class)
						.possibleValues(new String[] { "sUA", "sCO"})
						.build(),
				}).build();
	}

	private static Type getFlightLegCollectionType() {
		return new CollectionBuilder().itemType(getFlightLegType()).build();
	}

	private static Type getFlightLegType() {
		return new ObjectBuilder().fields(
				new Field[] {
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
						.build(),
				}).build();
	}

	private static Type getAircraftType() {
		return new ObjectBuilder().fields(
				new Field[] {
						new FieldBuilder().name("aircraftId")
						.type(StringType.class)
						.build(),
						new FieldBuilder().name("type")
						.type(StringType.class)
						.build(),
						new FieldBuilder().name("tailNumber")
						.type(StringType.class)
						.build(),
				}).build();
	}

	private static ObjectType getDomicileType() {
		return new ObjectBuilder().fields(
				new Field[] {
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
						.build(),
				}).build();
	}

	private static ObjectType getAirportType() {
		return new ObjectBuilder().fields(
				new Field[] {
						new FieldBuilder().name("airportCode")
						.type(StringType.class)
						.build(),
						new FieldBuilder().name("locationCoarseAddress")
						.type(getCoarseAddressType())
						.build(),
						new FieldBuilder().name("anchorCitiesCoarseAddress")
						.type(getCoarseAddressCollectionType())
						.build(),
				}).build();
	}

	private static Type getCoarseAddressCollectionType() {
		return new CollectionBuilder().itemType(getCoarseAddressType()).build();
	}

	private static ObjectType getCoarseAddressType() {
		return new ObjectBuilder().fields(
				new Field[] {
						new FieldBuilder().name("city")
						.type(StringType.class)
						.build(),
						new FieldBuilder().name("stateOrProvince")
						.type(StringType.class)
						.build(),
						new FieldBuilder().name("country")
						.type(StringType.class)
						.build(),
				}).build();
	}

	private static void generateJsonSchema(Class<?>[][] classGroups)
			throws JsonProcessingException {
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

	private static <T> String getJsonSchema(ObjectMapper mapper,
			SchemaFactoryWrapper visitor, Class<T> clazz)
			throws JsonProcessingException {
		mapper.acceptJsonFormatVisitor(clazz, visitor);
		JsonSchema schema = visitor.finalSchema();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(
				schema);
	}
}
