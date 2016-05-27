package com.personalcapital.simulation.application;

import java.util.ArrayList;
import java.util.Collections;


public class ProjectionResult {
	private Double median = null;
	private Double best = null;
	private Double worst = null;
	private ArrayList<Double> data;
	
	public ProjectionResult(int count) {
		super();
		data = new ArrayList<Double>(count);
	}
	
	void addData(double value) {
		data.add(value);
	}
	
	private double getPercentileValue(double p) {
		Collections.sort(data);
		int n = data.size();
		if (n == 1) {
			return data.get(0);
		}
		double p_index =  p * (n) / 100;
		if (p_index < 1 ) {
			return data.get(0);
		}
		else if (p_index >= n - 1 ){
			return data.get(n - 1);
		}
		int l_index = (int) Math.floor(p_index);
		double diff = p_index - l_index;
		double l_val = data.get(l_index);
		double h_val = data.get(l_index + 1);
		return (l_val + (h_val - l_val) * diff);
	}

	public double getMedian() {
		if (median == null) {
			median = getPercentileValue(50);
		}
		return median;
	}

	public double getBest() {
		if (best == null) {
			best = getPercentileValue(90);
		}
		return best;
	}

	public double getWorst() {
		if (worst == null) {
			worst = getPercentileValue(10);
		}
		return worst;
	}

		
}
