package com.primeholding.marko.parking.common.impl.factory;

import com.primeholding.marko.parking.common.Bay;
import com.primeholding.marko.parking.common.BayFactory;
import com.primeholding.marko.parking.common.impl.BayForDisabled;
import com.primeholding.marko.parking.common.impl.BayForNonDisabled;
import com.primeholding.marko.parking.common.impl.BayType;
import com.primeholding.marko.parking.common.impl.NullBay;
import com.primeholding.marko.parking.common.impl.PedestrianExitBay;

public class SimpleBayFactory implements BayFactory {

	@Override
	public Bay createNullBay() {
		return new NullBay(BayType.NULL_BAY);
	}

	@Override
	public Bay createPedestrianExitBay() {
		return new PedestrianExitBay(BayType.PEDESTRIAN_EXIT);
	}

	@Override
	public Bay createBayForDisabled() {
		return new BayForDisabled(BayType.EMPTY_BAY_FOR_DISABLED);
	}

	@Override
	public Bay createBayForNonDisabled() {
		return new BayForNonDisabled(BayType.EMPTY_BAY_FOR_NON_DISABLED);
	}

}
