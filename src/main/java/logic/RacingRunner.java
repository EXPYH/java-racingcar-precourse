package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import car.Car;
import car.CarList;
import car.CarName;
import car.Distance;
import car.engine.CarEngine;

public class RacingRunner {

	private static final Scanner scan = new Scanner(System.in);
	private static final InputValidator inputValidator = new InputValidator();

	public String getResultMessage(CarList carList) {
		StringBuilder str = new StringBuilder();
		for (Car winner : carList.getWinners()) {
			str.append(winner.getCarNameStr());
			str.append(", ");
		}
		str.setLength(str.length() - 2);
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
		System.out.println("시도할 횟수는 몇회인가요?");
		String moveCountInputStr = scan.nextLine();
		while (!inputValidator.isValidCount(moveCountInputStr)) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("시도할 횟수는 몇회인가요?");
			moveCountInputStr = scan.nextLine();
		}
		return Integer.parseInt(moveCountInputStr);
	}

	public CarList registerCarList() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
		List<String> carInputStr = getCarInputStr(scan.nextLine());
		while (!inputValidator.isValidCarNamesInput(carInputStr)) {
			System.out.println("잘못된 입력입니다. 5글자 이하의 이름을 입력하세요.");
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
			carInputStr = getCarInputStr(scan.nextLine());
		}
		return makeCarListFromStrings(carInputStr);
	}

	private CarList makeCarListFromStrings(List<String> carInputStr) {
		List<Car> cars = new ArrayList<>();
		for (String carNameStr : carInputStr) {
			cars.add(new Car(new CarName(carNameStr), new Distance(0)));
		}
		return new CarList(cars);
	}

	private List<String> getCarInputStr(String input) {
		return new ArrayList<>(Arrays.asList(input.split(",")));
	}
}
