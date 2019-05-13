package com.primeholding.marko.parking.common;

/**
 * A car factory interface for creating {@linkplain Car} objects.
 * 
 * @author Marko Vuckovic
 */
public interface CarFactory {

	/**
	 * Creates a {@linkplain Car} based on a car type.
	 * 
	 * @param carType type of the car
	 * 
	 * @return {@linkplain Car} object
	 */
	Car createCar(char carType);
	
}
