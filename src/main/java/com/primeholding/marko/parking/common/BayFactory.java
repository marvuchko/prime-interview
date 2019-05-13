package com.primeholding.marko.parking.common;

/**
 * A factory for creating {@linkplain Bay} objects.
 * 
 * @author Marko Vuckovic
 */
public interface BayFactory {

	/**
	 * Creates a "Null object" {@linkplain Bay} that serves as a
	 * safe replacement for {@code null}.
	 * 
	 * @param index index of "null" object
	 * 
	 * @return "Null object" instance
	 */
	Bay createNullBay(int index);
	
	/**
	 * Creates a pedestrian bay.
	 * 
	 * @param index position of the pedestrian bay.
	 * 
	 * @return pedestrian bay
	 */
	Bay createPedestrianExitBay(int index);
	
	/**
	 * Creates a bay for disabled persons.
	 * 
	 * @param index position of the bay for disabled persons
	 * 
	 * @return bay for disabled persons
	 */
	Bay createBayForDisabled(int index);
	
	/**
	 * Creates a bay for non disabled persons.
	 * 
	 * @param index position of the bay for non disabled persons
	 * 
	 * @return bay for non disabled persons
	 */
	Bay createBayForNonDisabled(int index);

}
