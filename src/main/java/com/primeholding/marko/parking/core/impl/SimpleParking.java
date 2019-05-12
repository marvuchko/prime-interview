package com.primeholding.marko.parking.core.impl;

import java.util.List;

import com.primeholding.marko.parking.common.Bay;
import com.primeholding.marko.parking.common.Car;
import com.primeholding.marko.parking.common.CarFactory;
import com.primeholding.marko.parking.core.Parking;
import com.primeholding.marko.parking.util.ListUtils;

/**
 * A simple concrete implementation of a {@linkplain Parking}.
 * 
 * @author Marko Vuckovic
 */
public class SimpleParking implements Parking {

	private CarFactory carFactory;
	
	private List<Bay> bays;

	private int size;

	public SimpleParking(SimpleParkingBuilder builder) {
		this.carFactory = builder.getCarFactory();
		this.bays = builder.getBays();
		this.size = builder.getSize();
	}

	@Override
	public int parkCar(char carType) {
		Car car = carFactory.createCar(carType);
		return 0;
	}

	@Override
	public boolean unparkCar(int index) {
		if (!ListUtils.checkIfIndexIsValid(bays, index)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int row = 0; row < size; row++) {
			if (row % 2 == 0) {
				for (int col = 0; col < size; col++) {
					builder.append(bays.get(row * size + col)).append(" ");
				}
			} else {
				for (int col = size - 1; col >= 0; col--) {
					builder.append(bays.get(row * size + col)).append(" ");
				}
			}
			builder.append("\n");
		}
		return builder.toString();
	}

}
