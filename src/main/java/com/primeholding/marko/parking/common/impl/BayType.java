package com.primeholding.marko.parking.common.impl;

public enum BayType {

	PEDESTRIAN_EXIT('='), 
	EMPTY_BAY_FOR_DISABLED('@'), 
	EMPTY_BAY_FOR_NON_DISABLED('U'),
	NULL_BAY('-');
	
	private final char type;
	
	private BayType(char type) {
		this.type = type;
	}

	public char getType() {
		return type;
	}
	
}
