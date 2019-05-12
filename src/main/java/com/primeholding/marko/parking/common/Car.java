package com.primeholding.marko.parking.common;

public class Car {

	private final CarType carType;

	public Car(CarType carType) {
		this.carType = carType;
	}

	public CarType getCarType() {
		return carType;
	}
	
}
