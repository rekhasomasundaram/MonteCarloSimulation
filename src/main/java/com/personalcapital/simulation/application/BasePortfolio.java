package com.personalcapital.simulation.application;
import org.apache.log4j.Logger;

import com.personalcapital.simulation.util.*;

public abstract class BasePortfolio implements PortfolioType {
	
	static Logger logger = Logger.getLogger(FutureProjection.class);

	 
	public double getProjectedReturn(double allocation, int years) {		
		double projected_allocation = allocation;
		for(int i=0; i<years; i++) {
			//logger.info("Year: "+i);
			double random_return = RandomUtil.nextGuassion(this.getMedianReturn(), this.getStandardRisk());
			//double return_amount = (projected_allocation * (random_return - 3.5) / 100);
			double return_amount = (projected_allocation * (((1 + random_return/100)/ (1  + 0.035)) - 1));
			projected_allocation += return_amount;
			
			
			//logger.info("projected_allocation: "+projected_allocation);

		}
		return projected_allocation;
	}

}
