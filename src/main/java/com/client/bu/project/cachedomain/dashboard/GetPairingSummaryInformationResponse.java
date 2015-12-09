package com.client.bu.project.cachedomain.dashboard;

import java.util.Date;
import java.util.List;

import com.client.bu.project.cachedomain.Pairing;

public class GetPairingSummaryInformationResponse {
  private Date date;
  private int pairingsCount;
  private int flightCount;
  private int alertCount;
  private List<Pairing> scheduledPairings;
  private List<Pairing> affectedPairings;
  private List<Pairing> openPairings;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getPairingsCount() {
    return pairingsCount;
  }

  public void setPairingsCount(int pairingsCount) {
    this.pairingsCount = pairingsCount;
  }

  public int getFlightCount() {
    return flightCount;
  }

  public void setFlightCount(int flightCount) {
    this.flightCount = flightCount;
  }

  public int getAlertCount() {
    return alertCount;
  }

  public void setAlertCount(int alertCount) {
    this.alertCount = alertCount;
  }

  public List<Pairing> getScheduledPairings() {
    return scheduledPairings;
  }

  public void setScheduledPairings(List<Pairing> scheduledPairings) {
    this.scheduledPairings = scheduledPairings;
  }

  public List<Pairing> getAffectedPairings() {
    return affectedPairings;
  }

  public void setAffectedPairings(List<Pairing> affectedPairings) {
    this.affectedPairings = affectedPairings;
  }

  public List<Pairing> getOpenPairings() {
    return openPairings;
  }

  public void setOpenPairings(List<Pairing> openPairings) {
    this.openPairings = openPairings;
  }

}
