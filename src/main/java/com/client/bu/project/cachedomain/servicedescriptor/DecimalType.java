package com.client.bu.project.cachedomain.servicedescriptor;

import java.math.BigDecimal;

public class DecimalType extends Primitive {

  @Override
  public java.lang.String getType() {
    return "Decimal";
  }

  @Override
  public Object getObjectSample() {
    return new BigDecimal(0);
  }
}
