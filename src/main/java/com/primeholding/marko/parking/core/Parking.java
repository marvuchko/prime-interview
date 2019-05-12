package com.primeholding.marko.parking.core;

/**
 * Handles the parking mechanisms: park/unpark a car (also for disabled-only
 * bays) and provides a string representation of its state.
 *
 * The previous <b>Parking</b> class is now an interface because in the future
 * we might have different implementations of the parking (e.g. parking for
 * flying cars...)
 * 
 * The code is much cleaner when <i>JavaDoc</i> is typed on an interface.
 * 
 * @author Marko Vuckovic
 */
public interface Parking {

	/**
	 * Parks the car of the given type ('D' being dedicated to disabled people) in
	 * closest -to pedestrian exit- and first (starting from the parking's entrance)
	 * available bay. Disabled people can only park on dedicated bays.
	 *
	 * @param carType the car {@code char} representation that has to be parked
	 * 
	 * @return bay index of the parked car, -1 if no applicable bay found
	 */
	int parkCar(final char carType);

	/**
	 * Unparks the car from the given index.
	 *
	 * @param index index of a car that needs to be unparked from the bay
	 * 
	 * @return true if a car was parked in the bay, false otherwise
	 */
	boolean unparkCar(final int index);

}
