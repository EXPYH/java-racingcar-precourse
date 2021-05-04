package car;

import java.util.Collections;
import java.util.List;

import car.engine.CarEngine;

public class CarList {
	private final List<Car> cars;

	public CarList(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars(){
		return cars;
	}

	public List<Car> getWinners(){
		int maxDistance = Collections.max(cars).getDistance().getValue();
		cars.removeIf(car -> car.getDistance().getValue() < maxDistance);
		return cars;
	}

	public void moveCars(CarEngine carEngine){
		for (Car car : cars){
			car.moveOneStepForward(carEngine);
		}
	}

	public void printCurrentDistances() {
		for (Car car : cars) {
			System.out.printf("%s : %s%n", car.getCarNameStr(), car.getDistanceStr());
		}
		System.out.println();
	}
}
