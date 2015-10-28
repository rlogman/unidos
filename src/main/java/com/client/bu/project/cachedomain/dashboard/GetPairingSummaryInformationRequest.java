package com.client.bu.project.cachedomain.dashboard;

import com.client.bu.project.cachedomain.AlertSummaryViewType;
import com.client.bu.project.cachedomain.Timeframe;

public class GetPairingSummaryInformationRequest {
	private Timeframe timeframe;
	private AlertSummaryViewType type;

	public Timeframe getTimeframe() {
		return timeframe;
	}

	public void setTimeframe(Timeframe timeframe) {
		this.timeframe = timeframe;
	}

	public AlertSummaryViewType getType() {
		return type;
	}

	public void setType(AlertSummaryViewType type) {
		this.type = type;
	}
}
