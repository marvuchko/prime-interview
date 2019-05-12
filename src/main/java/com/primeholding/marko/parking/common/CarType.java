package com.primeholding.marko.parking.common;

public enum CarType {

	CAR_FOR_NON_DISABLED('N'), 
	CAR_FOR_DISABLED('D');
	
	private final char type;
	
	private CarType(char type) {
		this.type = type;
	}
	
	public final char getType() {
		return type;
	}
	
}
