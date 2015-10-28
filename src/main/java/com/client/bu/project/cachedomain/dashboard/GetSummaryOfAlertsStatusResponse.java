package com.client.bu.project.cachedomain.dashboard;

import java.util.List;

public class GetSummaryOfAlertsStatusResponse {
	private List<GetPairingSummaryInformationResponseDetails> alerts;

	public List<GetPairingSummaryInformationResponseDetails> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<GetPairingSummaryInformationResponseDetails> alerts) {
		this.alerts = alerts;
	}
}
