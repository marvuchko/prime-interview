package com.primeholding.marko.parking.core.impl;

import java.util.ArrayList;
import java.util.List;

import com.primeholding.marko.parking.common.Bay;
import com.primeholding.marko.parking.common.BayFactory;
import com.primeholding.marko.parking.common.CarFactory;
import com.primeholding.marko.parking.core.Parking;
import com.primeholding.marko.parking.core.ParkingBuilder;
import com.primeholding.marko.parking.util.ListUtils;

public class SimpleParkingBuilder implements ParkingBuilder {

	private final int DEFAULT_SIZE = 5;
	
	private BayFactory bayFactory;
	
	private CarFactory carFactory;
	
	private List<Bay> bays;
	
	private int size;

	public SimpleParkingBuilder(BayFactory bayFactory, CarFactory carFactory) {
		this.bayFactory = bayFactory;
		this.carFactory = carFactory;
		this.bays = new ArrayList<>();
		this.size = DEFAULT_SIZE;
	}
	
	public CarFactory getCarFactory() {
		return carFactory;
	}

	public List<Bay> getBays() {
		return bays;
	}

	public int getSize() {
		return size;
	}

	@Override
	public ParkingBuilder withSquareSize(int size) {
		this.size = size;
		bays = new ArrayList<>();
		for (int i = 0; i < size * size; i++) {
			bays.add(bayFactory.createBayForNonDisabled(i));
		}
		return this;
	}

	@Override
	public ParkingBuilder withPedestrianExit(int pedestrianExitIndex) {
		if (!ListUtils.checkIfIndexIsValid(bays, pedestrianExitIndex))
			return this;
		bays.set(pedestrianExitIndex, bayFactory.createPedestrianExitBay(pedestrianExitIndex));
		return this;
	}

	@Override
	public ParkingBuilder withDisabledBay(int disabledBayIndex) {
		if (!ListUtils.checkIfIndexIsValid(bays, disabledBayIndex))
			return this;
		bays.set(disabledBayIndex, bayFactory.createBayForDisabled(disabledBayIndex));
		return this;
	}

	@Override
	public Parking build() {
		return new SimpleParking(this);
	}

}
