import car.engine.Bound;
import car.engine.CarEngine;
import car.CarList;
import car.engine.Criteria;
import logic.RacingRunner;

public class Application {
	public static void main(String[] args) {
		RacingRunner racingRunner = new RacingRunner();
		CarEngine carEngine = new CarEngine(new Bound(10), new Criteria(4));
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
		CarList carList = racingRunner.registerCarList();
		System.out.println("시도할 횟수는 몇회인가요?");
		racingRunner.startRace(carList, carEngine);
		System.out.println(racingRunner.getResultMessage(carList));
	}
}
