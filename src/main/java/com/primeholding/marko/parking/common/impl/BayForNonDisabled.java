package com.primeholding.marko.parking.common.impl;

import com.primeholding.marko.parking.common.Bay;
import com.primeholding.marko.parking.common.CarType;

public class BayForNonDisabled extends Bay {

	public BayForNonDisabled(BayType type, int index) {
		super(type, index);
	}

	@Override
	public boolean canPark(char carType) {
		return carType == CarType.CAR_FOR_NON_DISABLED.getType() && isFree();
	}

}
