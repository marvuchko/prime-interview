package com.primeholding.marko.parking.common;

/**
 * A factory for creating {@linkplain Bay} objects.
 * 
 * @author Marko Vuckovic
 */
public interface BayFactory {

	/**
	 * 
	 * @param carType
	 * @return
	 */
	Bay createNullBay();
	
	Bay createPedestrianExitBay();
	
	Bay createBayForDisabled();
	
	Bay createBayForNonDisabled();

}
