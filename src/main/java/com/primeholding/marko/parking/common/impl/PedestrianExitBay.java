package com.primeholding.marko.parking.common.impl;

import com.primeholding.marko.parking.common.Bay;

public class PedestrianExitBay extends Bay {

	public PedestrianExitBay(BayType type) {
		super(type);
	}

	@Override
	public boolean canPark(char carType) {
		return false;
	}

}
