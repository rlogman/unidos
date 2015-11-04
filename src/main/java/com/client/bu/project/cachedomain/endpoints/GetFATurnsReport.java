/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.bu.project.cachedomain.endpoints;

import com.client.bu.project.cachedomain.servicedescriptor.CollectionBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.DateTimeType;
import com.client.bu.project.cachedomain.servicedescriptor.Field;
import com.client.bu.project.cachedomain.servicedescriptor.FieldBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.Int32;
import com.client.bu.project.cachedomain.servicedescriptor.ObjectBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.ObjectType;
import com.client.bu.project.cachedomain.servicedescriptor.ServiceDescriptorBuilder;
import com.client.bu.project.cachedomain.servicedescriptor.StringType;
/**
 *
 * @author berenice.morales
 * @since 1.0
 * @version 1.0
 */
public class GetFATurnsReport extends ServiceDescriptorBuilder {

	public GetFATurnsReport() {
		this.name("getLineHoldersOrReservesList")
		.description("")
		.urlPattern("")
		.filters(new Field[] {
				new FieldBuilder().name("crewType")
						.type(StringType.class)
						.possibleValues(new String[] {
								"domestic",
								"international"
						})
						.build(),
				new FieldBuilder().name("fromDateTime")
						.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
						.build(),
				new FieldBuilder().name("toDateTime")
						.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
						.build(),
				new FieldBuilder().name("station")
						.type(StringType.class)
						.build(),
		})
		.parameters(new Field[] {
				new FieldBuilder().name("sortBy")
						.type(StringType.class)
						.possibleValues(new String[] {
								"operationalDeparture",
								"operationalArrival"
						})
						.build(),
		})
		.returnType(new CollectionBuilder().itemType(new ObjectBuilder().fields(new Field[] {
				new FieldBuilder().name("tripDetail").type(new ObjectBuilder().fields(new Field[] {
								new FieldBuilder().name("id-dt")
										.type(StringType.class)
										.build(),
								new FieldBuilder().name("pos")
										.type(new CollectionBuilder().itemType(StringType.class).build())
										.build(),
								new FieldBuilder().name("domicile")
										.type(StringType.class)
										.build(),
								new FieldBuilder().name("count")
										.type(Int32.class)
										.build(),
						}).build())
						.build(),
				new FieldBuilder().name("inboundSegment").type(getTurnSegmentType())
						.build(),
				new FieldBuilder().name("acm")
						.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
						.build(),
				new FieldBuilder().name("adt")
						.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
						.build(),
				new FieldBuilder().name("l/o")
						.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
						.build(),
				new FieldBuilder().name("outboundSegment").type(getTurnSegmentType())
						.build(),
		}).build()).build());
	}

	private static ObjectType getTurnSegmentType() {
		return new ObjectBuilder().fields(new Field[] {
				new FieldBuilder().name("flt")
						.type(Int32.class)
						.build(),
				new FieldBuilder().name("dt")
						.type(Int32.class)
						.build(),
				new FieldBuilder().name("airport")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("gate")
						.type(StringType.class)
						.build(),
				new FieldBuilder().name("timestamp")
						.type(DateTimeType.UTC_TIMESTAMP_MINUTES)
						.build(),
				new FieldBuilder().name("rmks")
						.type(StringType.class)
						.build(),
		}).build();
	}
}
