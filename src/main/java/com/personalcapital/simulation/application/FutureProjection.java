package com.personalcapital.simulation.application;

import org.apache.log4j.Logger;

public class FutureProjection {
	
	static Logger logger = Logger.getLogger(FutureProjection.class);
	
	public static ProjectionResult runProjectionSimulation(PortfolioType portfolio, double allocation, int years, int count) {
		ProjectionResult result = new ProjectionResult(count);
		for(int i=0; i<count; i++) {
			double projected_return = portfolio.getProjectedReturn(allocation, years);
			result.addData(projected_return);
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		logger.debug("Start of Simulation for Aggressive Portfolio");

		PortfolioType portfolioAggr = new AggressivePortfolio();
	    double allocation = 100000;
	    ProjectionResult resultAggr = runProjectionSimulation(portfolioAggr, allocation, 20, 10000); 
	    logger.info("Aggressive Portfolio Results: ");
	    logger.info("Median 20th Year " + Math.round(resultAggr.getMedian()));
	    logger.info("10% Best Case " + Math.round(resultAggr.getBest()));
	    logger.info("10% Worst Case " + Math.round(resultAggr.getWorst()));
	    
	    
		logger.debug("Start of Simulation for Conservative Portfolio");
		
		PortfolioType portfolioCons = new ConservativePortfolio();
	    ProjectionResult resultCons = runProjectionSimulation(portfolioCons, allocation, 20, 10000); 
	    
	    logger.info("Conservative Portfolio Results: ");
	    logger.info("Median 20th Year " + Math.round(resultCons.getMedian()));
	    logger.info("10% Best Case " + Math.round(resultCons.getBest()));
	    logger.info("10% Worst Case " + Math.round(resultCons.getWorst()));
	    
	   



	}
	
}
