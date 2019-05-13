package com.primeholding.marko.parking.common.impl.factory;

import com.primeholding.marko.parking.common.Car;
import com.primeholding.marko.parking.common.CarFactory;
import com.primeholding.marko.parking.common.CarType;

/**
 * A factory method implementation of a {@linkplain CarFactory}.
 * 
 * @author Marko Vuckovic
 */
public class SimpleCarFactoryMethod implements CarFactory {

	@Override
	public Car createCar(char carType) {
		if (carType == CarType.CAR_FOR_DISABLED.getType())
			return new Car(CarType.CAR_FOR_DISABLED);
		if (carType == CarType.CAR_FOR_NON_DISABLED.getType())
			return new Car(CarType.CAR_FOR_NON_DISABLED);
		throw new IllegalArgumentException("No such car!");
	}

}
