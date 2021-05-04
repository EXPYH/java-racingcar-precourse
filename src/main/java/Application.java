import car.CarList;
import car.engine.Bound;
import car.engine.CarEngine;
import car.engine.Criteria;
import constants.RacingConst;
import logic.RacingRunner;

public class Application {
	public static void main(String[] args) {
		RacingRunner racingRunner = new RacingRunner();
		CarEngine carEngine =
			new CarEngine(new Bound(RacingConst.BOUND), new Criteria(RacingConst.CRITERIA));
		CarList carList = racingRunner.registerCarList();
		racingRunner.startRace(carList, carEngine);
		System.out.println(racingRunner.getResultMessage(carList));
	}
}
