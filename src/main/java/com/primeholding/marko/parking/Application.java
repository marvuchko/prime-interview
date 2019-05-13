package com.primeholding.marko.parking;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.primeholding.marko.parking.common.CarType;
import com.primeholding.marko.parking.core.Parking;
import com.primeholding.marko.parking.core.ParkingBuilder;
import com.primeholding.marko.parking.util.AsciiArtUtil;

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
		
		logger.info("\n" + AsciiArtUtil.INIT_MESSAGE);
	
		ParkingBuilder parkingBuilder = (ParkingBuilder) context.getBean(BeanConstants.PARKING_BUILDER_BEAN);
		
		Parking parking = parkingBuilder
				.withSquareSize(10)
				.withPedestrianExit(33)
				.withPedestrianExit(47)
				.withDisabledBay(19)
				.withDisabledBay(22)
				.withDisabledBay(24)
				.build();
		
		logger.info("\n\nInitial state:\n\n" + parking);
		
		parking.parkCar(CarType.CAR_FOR_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		
		logger.info("\n\nAfter parking one car for disabled people \n"
				+ "and one for non disabled:\n\n" + parking);
		
		parking.parkCar(CarType.CAR_FOR_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		
		logger.info("\n\nAfter parking one more car for disabled people \n"
				+ "and five more for non disabled:\n\n" + parking);

		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		parking.parkCar(CarType.CAR_FOR_NON_DISABLED.getType());
		
		logger.info("\n\nAfter parking twelve more cars for non disabled:\n\n" + parking);
		
	}
	
}
