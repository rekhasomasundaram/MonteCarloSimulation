package com.personalcapital.simulation.util;


import java.util.Random;

public class RandomUtil {

	/**
	 * Generates a pseudo-random number based on the provided median and standard deviation
	 * 
	 * @param median - the median 
	 * @param sd - the standard deviation
	 * @return a pseudo-random number based on guassian distribution
	 */
	public static double nextGuassion(double median, double sd) {
		Random r = new Random();
		double z = r.nextGaussian();
		return (z * sd + median);
	}
}
