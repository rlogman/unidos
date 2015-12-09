package com.client.bu.project.cachedomain.profile;

import com.client.bu.project.cachedomain.BaseOrFleet;

public class ChangeFleetSelectionRequest {
  private String userid;
  private BaseOrFleet type;
  private BaseOrFleet selection;

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public BaseOrFleet getType() {
    return type;
  }

  public void setType(BaseOrFleet type) {
    this.type = type;
  }

  public BaseOrFleet getSelection() {
    return selection;
  }

  public void setSelection(BaseOrFleet selection) {
    this.selection = selection;
  }
}
