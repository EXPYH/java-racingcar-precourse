package car.engine;

import java.util.Random;

public class CarEngine {
	private final Random rand ;
	private Bound bound;
	private Criteria criteria;

	public CarEngine(Bound bound, Criteria criteria) {
		this.rand = new Random();
		this.bound = bound;
		this.criteria = criteria;
	}

	private int generateNumber(){
		return rand.nextInt(bound.getValue());
	}

	public boolean isSuccessToRun(){
		return generateNumber() >= criteria.getValue();
	}
}
