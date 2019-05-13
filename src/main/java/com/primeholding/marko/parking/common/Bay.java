package com.primeholding.marko.parking.common;

import com.primeholding.marko.parking.common.impl.BayType;

/**
 * An abstract class for representing the parking bay.
 * 
 * @author Marko Vuckovic
 */
public abstract class Bay {

	private Car car;

	private final BayType bayType;

	private final int index;

	public Bay(BayType bayType, int index) {
		this.bayType = bayType;
		this.index = index;
	}

	public BayType getBayType() {
		return bayType;
	}

	public int getIndex() {
		return index;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	/**
	 * Checks if the parking bay is taken or not.
	 * 
	 * @return {@code true} if the bay has not been taken and 
	 * 		   {@code false} if the bay has been taken.
	 */
	public boolean isFree() {
		return car == null;
	}

	/**
	 * Checks if the specified car bayType can be parked on this bay.
	 * 
	 * @param carbayType the bayType of the car.
	 * 
	 * @return {@code true} if the car can be parked on this bay and 
	 * 		   {@code false} if the car cannot be parked on this bay.
	 */
	public abstract boolean canPark(char carType);

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		if (isFree())
			text.append(bayType.getType());
		else
			text.append(car);
		return text.toString();
	}

}
