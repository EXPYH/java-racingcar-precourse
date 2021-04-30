package car;

public class Distance {
	private int value;

	public Distance(int value) {
		if (value < 0){
			throw new IllegalArgumentException();
		}
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public String getCurrentDistanceStr() {
		StringBuilder distanceBuffer = new StringBuilder();
		for (int i = 0; i < this.value; ++i){
			distanceBuffer.append("-");
		}
		return distanceBuffer.toString();
	}

	public void increaseDistance(int distance) {
		value += distance;
	}
}
