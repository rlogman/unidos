package com.client.bu.project.cachedomain.servicedescriptor;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"kind", "type", "format", "timeZone"})
public class DateTimeType extends Primitive {
  public static final Type UTC_TIMESTAMP_MINUTES = new DateTimeType() {
    {
      this.format = "yyyy-MM-ddTHH:mm";
      this.timeZone = "UTC";
    }
  };

  public static final Type UTC_TIMESTAMP_SECONDS = new DateTimeType() {
    {
      this.format = "yyyy-MM-ddTHH:mm:ss";
      this.timeZone = "UTC";
    }
  };

  public static final Type UTC_DATE = new DateTimeType() {
    {
      this.format = "yyyy-MM-dd";
      this.timeZone = "UTC";
    }
  };

  public static final Type UTC_MONTH = new DateTimeType() {
    {
      this.format = "yyyy-MM";
      this.timeZone = "UTC";
    }
  };

  public static final Type DURATION_HOURS = new DateTimeType() {
    {
      this.format = "HH";
      this.timeZone = "UTC";
    }
  };

  public static final Type DURATION_MINUTES = new DateTimeType() {
    {
      this.format = "HH:mm";
      this.timeZone = "UTC";
    }
  };

  public static final Type UTC_TIMESTAMP_YEAR = new DateTimeType() {
    {
      this.format = "ddyy:MM:yy";
      this.timeZone = "UTC";
    }
  };
  protected String format;
  protected String timeZone;

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  @Override
  public java.lang.String getType() {
    return "DateTime";
  }

  @Override
  public Object getObjectSample() {
    return new Date(System.currentTimeMillis());
  }
}
