package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import car.Car;
import car.engine.CarEngine;
import car.CarList;
import car.CarName;
import car.Distance;

public class RacingRunner {

	private static final Scanner scan = new Scanner(System.in);
	private static final InputValidator inputValidator = new InputValidator();

	public String getResultMessage(CarList carList) {
		StringBuilder str = new StringBuilder();
		for (Car winner : carList.getWinners()){
			str.append(winner.getCarNameStr());
			str.append(", ");
		}
		str.setLength(str.length()-2);
		str.append("가 최종 우승했습니다.");
		return str.toString();
	}

	public void startRace(CarList carList, CarEngine carEngine) {
		int moveCount = getMoveCount();
		for (int i = 0; i < moveCount; ++i) {
			runRace(carList, carEngine);
		}
	}

	private void runRace(CarList carList, CarEngine carEngine) {
		carList.moveCars(carEngine);
		carList.printCurrentDistances();
	}


	private int getMoveCount() {
		String moveCountInputStr = scan.nextLine();
		while (!inputValidator.isValidCount(moveCountInputStr)){
			moveCountInputStr = scan.nextLine();
		}
		return Integer.parseInt(moveCountInputStr);
	}

	public CarList registerCarList() {
		List<String> carInputStr = getCarInputStr(scan.nextLine());
		while(!inputValidator.isValidCarNamesInput(carInputStr)){
			carInputStr = getCarInputStr(scan.nextLine());
		}
		return makeCarListFromStrings(carInputStr);
	}

	private CarList makeCarListFromStrings(List<String> carInputStr) {
		List<Car> cars = new ArrayList<>();
		for (String carNameStr : carInputStr){
			cars.add(new Car(new CarName(carNameStr), new Distance(0)));
		}
		return new CarList(cars);
	}

	private List<String> getCarInputStr(String input) {
		return new ArrayList<>(Arrays.asList(input.split(",")));
	}
}
