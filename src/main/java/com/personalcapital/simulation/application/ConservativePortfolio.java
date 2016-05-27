package com.personalcapital.simulation.application;

public class ConservativePortfolio extends BasePortfolio implements PortfolioType{

	final double AVG_RETURN = 6.189;
	final double SD_RISK = 6.3438;
	
	@Override
	public double getMedianReturn() {
		return AVG_RETURN;
	}

	@Override
	public double getStandardRisk() {
		return SD_RISK;
	}

}
