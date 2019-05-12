package com.primeholding.marko.parking.core;

/**
 * Builder interface to get a parking instance. It may have more than one
 * implementation in the future if the building process should give us different
 * results.
 * 
 * @author Marko Vuckovic
 */
public interface ParkingBuilder {

	ParkingBuilder withSquareSize(final int size);

	ParkingBuilder withPedestrianExit(final int pedestrianExitIndex);

	ParkingBuilder withDisabledBay(final int disabledBayIndex);

	Parking build();

}
