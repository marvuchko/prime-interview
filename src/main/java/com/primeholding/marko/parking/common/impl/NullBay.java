package com.primeholding.marko.parking.common.impl;

import com.primeholding.marko.parking.common.Bay;

/**
 * A null object class for representing the null {@linkplain Bay} in the parking.
 * 
 * The example of "Null object" pattern commonly used when we want to initialize
 * the parking with an array of null objects instead of nulls.
 * 
 * @author Marko Vuckovic
 */
public class NullBay extends Bay {

	public NullBay(BayType type) {
		super(type);
	}

	@Override
	public boolean isFree() {
		return false;
	}
	
	@Override
	public boolean canPark(char carType) {
		return false;
	}

}
