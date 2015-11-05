package com.client.bu.project.cachedomain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Timeframe {
  @JsonProperty("2h")
  TWO,

  @JsonProperty("6h")
  SIX,

  @JsonProperty("8h")
  EIGHT,

  @JsonProperty("12h")
  TWELVE,

  @JsonProperty("24h")
  DAY,

  @JsonProperty("36h")
  THIRTY_SIX,

  @JsonProperty("48h")
  FORTY_EIGHT,

  @JsonProperty("72h")
  SEVENTY_TWO;

}
