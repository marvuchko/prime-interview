package com.primeholding.marko.parking.core.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.primeholding.marko.parking.common.CarType;
import com.primeholding.marko.parking.common.impl.factory.SimpleBayFactory;
import com.primeholding.marko.parking.common.impl.factory.SimpleCarFactoryMethod;
import com.primeholding.marko.parking.core.ParkingBuilder;

public class SimpleParkingTest {

	private SimpleParking simpleParking;
	
	@Rule
	public ExpectedException expectedException;

	@Before
	public void init() {
		expectedException = ExpectedException.none();
		ParkingBuilder parkingBuilder = new SimpleParkingBuilder(new SimpleBayFactory(), new SimpleCarFactoryMethod());
		simpleParking = (SimpleParking) parkingBuilder
				.withSquareSize(10)
				.withPedestrianExit(33)
				.withPedestrianExit(47)
				.withDisabledBay(19)
				.withDisabledBay(22)
				.withDisabledBay(24)
				.build();
	}
	
	@Test
	public void anInvalidCarTypeAddedTest() {
		expectedException.expect(IllegalArgumentException.class);
		simpleParking.parkCar('+');
	}
	
	@Test
	public void carIsAddedCorrectlyTest() {
		Integer index = simpleParking.parkCar(CarType.CAR_FOR_DISABLED.getType());
		assertThat(index, not(equalTo(-1)));
	}
	
	@Test
	public void carIsRemovedCorrectlyTest() {
		int index = simpleParking.parkCar(CarType.CAR_FOR_DISABLED.getType());
		boolean isUnparked = simpleParking.unparkCar(index);
		assertEquals("Car was not unparked.", true, isUnparked);
	}

}
