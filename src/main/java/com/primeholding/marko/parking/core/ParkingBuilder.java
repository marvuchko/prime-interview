package com.primeholding.marko.parking.core;

/**
 * Builder interface to get a parking instance. It may have more than one
 * implementation in the future if the building process should give us different
 * results.
 * 
 * @author Marko Vuckovic
 */
public interface ParkingBuilder {

	/**
	 * Defines the size of the line on the Parking.
	 * 
	 * @param size size of the line
	 * 
	 * @return reference to this {@linkplain ParkingBuilder}
	 */
	ParkingBuilder withSquareSize(final int size);

	/**
	 * Defines the pedestrian exit on a given position.
	 * 
	 * @param pedestrianExitIndex index of the pedestrian bay
	 * 
	 * @return reference to this {@linkplain ParkingBuilder}
	 */
	ParkingBuilder withPedestrianExit(final int pedestrianExitIndex);

	/**
	 * Defines a parking bay for disabled persons.
	 * 
	 * @param disabledBayIndex index of the bay for the disabled persons
	 * 
	 * @return reference to this {@linkplain ParkingBuilder}
	 */
	ParkingBuilder withDisabledBay(final int disabledBayIndex);

	/**
	 * Creates a new instance of a {@linkplain Parking}
	 * object.
	 * 
	 * @return
	 */
	Parking build();

}
