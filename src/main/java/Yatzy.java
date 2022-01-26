import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Yatzy {

	protected static List<Integer> dice;

	public Yatzy(int d1, int d2, int d3, int d4, int d5) {
		dice = Arrays.asList(d1, d2, d3, d4, d5);
	}

	public int chance() {
		int sum = 0;
		for (int value : dice) {
			sum += value;
		}
		return sum;
	}

	public int yatzy() {
			return getFrequency(dice.get(0)) == 5?50:0;
	}

	public int placed_on(int placed) {

		int sum = 0;
		for (int value : dice) {
			if (value == placed)
				sum += placed;
		}
		return sum;
	}

	public int score_pair() {
		int sum = 0;
		int first = 0;
		for (int value : dice) {
			if (getFrequency(value) >= 2) {
				if (first < value) {
					first = value;
					sum = first * 2;
				}
			}
		}
		return sum;
	}

	public int two_pair() {
		int sum = 0;
		int count = 0;
		int first = 0;
		for (int value : dice) {
			if (getFrequency(value) >= 2 && getFrequency(value) <= 3) {
				if (first != value) {
					first = value;
					sum += first * 2;
					count++;
				}
				if (count == 2)
					return sum;

			}
		}

		return 0;
	}

	public int four_of_a_kind() {
		int i=0;
		while(i<3) {
			if (getFrequency(dice.get(i)) >= 4) {
				return dice.get(i) * 4;
			}
			i++;
		}

		return 0;
	}

	public int three_of_a_kind() {

		int i=0;
		while(i<2) {
			if (getFrequency(dice.get(i)) >= 3) {
				return dice.get(i) * 3;
			}
			i++;
		}
		return 0;
	}

	public int smallStraight() {
		if (!dice.contains(6)) {
			for (int value : dice) {
				if (getFrequency(value) != 1)
					return 0;
			}
		} else {
			return 0;
		}
		return 15;
	}

	public int largeStraight() {
		if (!dice.contains(1)) {
			for (int value : dice) {
				if (getFrequency(value) != 1)
					return 0;
			}
		} else {
			return 0;
		}
		return 20;
	}

	public int fullHouse() {
		int sum2 = 0;
		int sum3 = 0;
		boolean _sum2 = false;
		boolean _sum3 = false;
		for (int value : dice) {
			if (getFrequency(value) == 3) {
				sum3 = value * 3;
				_sum3 = true;
			}
			if (getFrequency(value) == 2)
				sum2 = value * 2;
			_sum2 = true;
		}
		return _sum2 && _sum3 ? sum2 + sum3 : 0;

	}

	public int getFrequency(int value) {
		return Collections.frequency(dice, value);
	}

}
