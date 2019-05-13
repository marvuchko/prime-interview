package com.primeholding.marko.parking.core.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.primeholding.marko.parking.common.Bay;
import com.primeholding.marko.parking.common.Car;
import com.primeholding.marko.parking.common.CarFactory;
import com.primeholding.marko.parking.common.impl.BayType;
import com.primeholding.marko.parking.core.Parking;
import com.primeholding.marko.parking.util.ListUtils;

/**
 * A simple concrete implementation of a {@linkplain Parking}.
 * 
 * @author Marko Vuckovic
 */
public class SimpleParking implements Parking {

	private CarFactory carFactory;

	private List<Bay> bays;

	private int size;

	public SimpleParking(SimpleParkingBuilder builder) {
		this.carFactory = builder.getCarFactory();
		this.bays = builder.getBays();
		this.size = builder.getSize();
	}

	@Override
	public int parkCar(char carType) {
		int parkingIndex = -1;
		if (!hasAvailableBays(carType))
			return parkingIndex;
		Car car = carFactory.createCar(carType);
		List<Bay> pedestrianExits = findAllPedestrianExits();
		Bay bestAvailableBay = findBestAvailable(pedestrianExits, carType);
		if (bestAvailableBay != null) {
			bestAvailableBay.setCar(car);
			parkingIndex = bestAvailableBay.getIndex();
		}
		return parkingIndex;
	}

	@Override
	public boolean unparkCar(int index) {
		if (!ListUtils.checkIfIndexIsValid(bays, index)) {
			return false;
		}
		if (!bays.get(index).isFree()) {
			bays.get(index).setCar(null);
			return true;
		}
		return false;
	}

	/**
	 * Helper method for determining is there a free {@linkplain Bay}
	 * for the specific {@linkplain Car} type or not.
	 * 
	 * @param carType type of the car we check bays for
	 * 
	 * @return {@code true} if there is available bay and 
	 * 		   {@code false} if theere is not.
	 */
	private boolean hasAvailableBays(char carType) {
		return bays.stream()
				.anyMatch(bay -> bay.canPark(carType) && bay.isFree());
	}

	/**
	 * Helper method that fetches all pedestrian exits on the parking.
	 * 
	 * @return a {@linkplain List} of {@linkplain Bay} that are pedestrian exits.
	 */
	private List<Bay> findAllPedestrianExits() {
		return bays.stream()
				.filter(bay -> bay.getBayType().equals(BayType.PEDESTRIAN_EXIT))
				.collect(Collectors.toList());
	}

	/**
	 * Helper method for finding best available spot on the parking
	 * for a specific car.
	 * 
	 * @param pedestrianExits
	 * @param carType type of the car
	 * 
	 * @return best available spot for the car if possible.
	 */
	private Bay findBestAvailable(List<Bay> pedestrianExits, char carType) {
		List<Bay> results = new ArrayList<>();
		pedestrianExits.stream().forEach(pedestrianExit -> {
			Bay tmpBest = findLocalBestBay(pedestrianExit, carType);
			results.add(tmpBest);
		});
		return findClosestToEnterance(results);
	}

	/**
	 * Helper method that fetches the result closest to the entrance.
	 * If we assume that entrance is (0, 0) coordinate in the matrix
	 * then the closest result to the entrance will be the one
	 * with the lowest index.
	 * 
	 * @param results the list of optimal results fetched by
	 * searcher algorithm
	 * 
	 * @return the result nearest to the entrance
	 */
	private Bay findClosestToEnterance(List<Bay> results) {
		if (results.isEmpty()) 
			return null;
		int minIndex = results.stream()
				.map(result -> result.getIndex())
				.min(Integer::compare).get();
		return bays.get(minIndex);
	}

	/**
	 * Helper method that fetches optimal bay for the targeted
	 * pedestrian exit.
	 * 
	 * @param pedestrianExit targeted pedestrian exit
	 * @param carType the type of the car bay is searched for.
	 * 
	 * @return optimal bay for the targeted pedestrian exit.
	 */
	private Bay findLocalBestBay(Bay pedestrianExit, char carType) {
		int row = pedestrianExit.getIndex() / size;
		int col = pedestrianExit.getIndex() % size;
		List<Integer> visitedIndexes = new ArrayList<>();
		int targetIndex = findLocalBestBayRecursive(row, col, carType, pedestrianExit.getIndex(), visitedIndexes);
		return bays.get(targetIndex);
	}

	/**
	 * Helper method that implements the searcher algorithm.
	 * fetches optimal bay for the targeted car type recursively.
	 * 
	 * @param row row of the initial bay
	 * @param col column of the initial bay
	 * @param carType type of the car bay is searched for
	 * @param startIndex index of the initial searching position
	 * @param visitedIndexes indexes of the visited bays.
	 * 
	 * @return index of the local optimal bay.
	 */
	private int findLocalBestBayRecursive(
			int row, 
			int col, 
			char carType, 
			int startIndex,
			List<Integer> visitedIndexes
	) {
		int index = row * size + col;
		
		if (!ListUtils.checkIfIndexIsValid(bays, index)) {
			return Integer.MAX_VALUE;
		}
		
		if (visitedIndexes.stream().anyMatch(visitedIndex -> visitedIndex.intValue() == index)) {
			return Integer.MAX_VALUE;
		}
		
		Bay bay = bays.get(index);
		if (bay.canPark(carType) && bay.isFree()) {
			return index;
		}
		
		visitedIndexes.add(index);
		
		int firstIndex = findLocalBestBayRecursive(row - 1, col - 1, carType, startIndex, visitedIndexes);
		int secondIndex = findLocalBestBayRecursive(row - 1, col, carType, startIndex, visitedIndexes);
		int thirdIndex = findLocalBestBayRecursive(row - 1, col + 1, carType, startIndex, visitedIndexes);
		int fourthIndex = findLocalBestBayRecursive(row, col - 1, carType, startIndex, visitedIndexes);
		int fifthIndex = findLocalBestBayRecursive(row, col + 1, carType, startIndex, visitedIndexes);
		int sixthIndex = findLocalBestBayRecursive(row + 1, col - 1, carType, startIndex, visitedIndexes);
		int seventhIndex = findLocalBestBayRecursive(row + 1, col, carType, startIndex, visitedIndexes);
		int eigthIndex = findLocalBestBayRecursive(row, col + 1, carType, startIndex, visitedIndexes);
		
		int resultIndex = closestToTarget(startIndex, firstIndex, secondIndex);
		resultIndex = closestToTarget(startIndex, resultIndex, thirdIndex);
		resultIndex = closestToTarget(startIndex, resultIndex, fourthIndex);
		resultIndex = closestToTarget(startIndex, resultIndex, fifthIndex);
		resultIndex = closestToTarget(startIndex, resultIndex, sixthIndex);
		resultIndex = closestToTarget(startIndex, resultIndex, seventhIndex);
		resultIndex = closestToTarget(startIndex, resultIndex, eigthIndex);
		
		return resultIndex;
	}
	
	private int closestToTarget(int refIndex, int firstIndex, int secondIndex) {
		if (firstIndex < size * size && secondIndex < size * size) {
			int minIndex = firstIndex;
			int rX = refIndex / size;
			int rY = refIndex % size;
			int fX = firstIndex / size;
			int fY = firstIndex % size;
			int sX = secondIndex / size;
			int sY = secondIndex % size;
			
			double firstDistance = Math.sqrt(Math.pow(rX - fX, 2) + Math.pow(rY - fY, 2));
			double secondDistance = Math.sqrt(Math.pow(rX - sX, 2) + Math.pow(rY - sY, 2));
			
			if (firstDistance > secondDistance) {
				minIndex = secondIndex;
			}
			
			return minIndex;
		}
		
		return Math.min(firstIndex, secondIndex);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int row = 0; row < size; row++) {
			builder.append("\t");
			for (int col = 0; col < size; col++) {
				builder.append(bays.get(row * size + col)).append(" ");
			}
			builder.append("\n");
		}
		return builder.toString();
	}

}
