package com.personalcapital.simulation.application;

public class AggressivePortfolio extends BasePortfolio implements PortfolioType {
	private final double AVG_RETURN = 9.4324;
	private final double SD_RISK = 15.675;
	
	@Override
	public double getMedianReturn() {
		return AVG_RETURN;
	}

	@Override
	public double getStandardRisk() {
		return SD_RISK;
	}

}
