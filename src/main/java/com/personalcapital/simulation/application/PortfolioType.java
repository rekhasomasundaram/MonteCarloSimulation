package com.personalcapital.simulation.application;

public interface PortfolioType {
	
	public double getMedianReturn();
	
	public double getStandardRisk();
			
	public double getProjectedReturn(double allocation, int years);
}
