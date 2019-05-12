package com.primeholding.marko.parking;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.primeholding.marko.parking.core.Parking;
import com.primeholding.marko.parking.core.ParkingBuilder;

/**
 * The main class of this application.
 * 
 * @author Marko Vuckovic
 */
public class Application {

	static Logger logger = Logger.getLogger(Application.class.getName());
	
	@SuppressWarnings("resource")
	public static void main(String... args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(ApplicationConstants.APPLICATION_CONTEXT_FILE);
		
		logger.info("Application has started working");
	
		ParkingBuilder parkingBuilder = (ParkingBuilder) context.getBean(ApplicationConstants.PARKING_BUILDER_BEAN);
		Parking parking = parkingBuilder
				.withSquareSize(10)
				.withPedestrianExit(1)
				.withDisabledBay(3)
				.withDisabledBay(15)
				.build();
		
		logger.info("\n\nParking: \n\n" + parking);
		
	}
	
}
