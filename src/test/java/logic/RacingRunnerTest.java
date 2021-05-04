package logic;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import car.Car;
import car.CarList;
import car.CarName;
import car.Distance;

public class RacingRunnerTest {

	private static RacingRunner racingRunner;

	@BeforeAll()
	public static void beforeAll(){
		racingRunner = new RacingRunner();
	}

	@Test
	void getResultMessage_MoreThanOneWinners_ReturnTrueMessage(){
		List<Car> cars = new ArrayList<>();
		cars.add(new Car(new CarName("1st"), new Distance(5)));
		cars.add(new Car(new CarName("2nd"), new Distance(3)));
		cars.add(new Car(new CarName("first"), new Distance(5)));
		CarList carList = new CarList(cars);
		assertThat(racingRunner.getResultMessage(carList)).isEqualTo("1st, first가 최종 우승했습니다.");
	}

	@Test
	void getResultMessage_OnlyOneWinners_ReturnTrueMessage(){
		List<Car> cars = new ArrayList<>();
		cars.add(new Car(new CarName("1st"), new Distance(5)));
		cars.add(new Car(new CarName("2nd"),new Distance(3)));
		cars.add(new Car(new CarName("3rd"), new Distance(2)));
		CarList carList = new CarList(cars);
		assertThat(racingRunner.getResultMessage(carList)).isEqualTo("1st가 최종 우승했습니다.");
	}
}
