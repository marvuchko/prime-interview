package com.primeholding.marko.parking.common.impl.factory;

import com.primeholding.marko.parking.common.Bay;
import com.primeholding.marko.parking.common.BayFactory;
import com.primeholding.marko.parking.common.impl.BayForDisabled;
import com.primeholding.marko.parking.common.impl.BayForNonDisabled;
import com.primeholding.marko.parking.common.impl.BayType;
import com.primeholding.marko.parking.common.impl.NullBay;
import com.primeholding.marko.parking.common.impl.PedestrianExitBay;

/**
 * A simple implementation of a {@linkplain BayFactory}.
 * 
 * @author Marko Vuckovic
 */
public class SimpleBayFactory implements BayFactory {

	@Override
	public Bay createNullBay(int index) {
		return new NullBay(BayType.NULL_BAY, index);
	}

	@Override
	public Bay createPedestrianExitBay(int index) {
		return new PedestrianExitBay(BayType.PEDESTRIAN_EXIT, index);
	}

	@Override
	public Bay createBayForDisabled(int index) {
		return new BayForDisabled(BayType.EMPTY_BAY_FOR_DISABLED, index);
	}

	@Override
	public Bay createBayForNonDisabled(int index) {
		return new BayForNonDisabled(BayType.EMPTY_BAY_FOR_NON_DISABLED, index);
	}

}
