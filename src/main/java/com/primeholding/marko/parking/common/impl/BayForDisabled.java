package com.primeholding.marko.parking.common.impl;

import com.primeholding.marko.parking.common.Bay;
import com.primeholding.marko.parking.common.CarType;

public class BayForDisabled extends Bay {

	public BayForDisabled(BayType type, int index) {
		super(type, index);
	}

	@Override
	public boolean canPark(char carType) {
		return carType == CarType.CAR_FOR_DISABLED.getType() && isFree();
	}

}
