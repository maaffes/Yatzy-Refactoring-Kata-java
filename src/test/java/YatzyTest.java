import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

	@Test
	public void chance_scores_sum_of_all_dice() {
		int expected = 15;
		int actual = new Yatzy(2, 3, 4, 5, 1).chance();
		assertEquals(expected, actual);
		assertEquals(16, new Yatzy(3, 3, 4, 5, 1).chance());
	}

	@Test
	public void yatzy_scores_50() {
		int expected = 50;
		int actual = new Yatzy(4, 4, 4, 4, 4).yatzy();
		assertEquals(expected, actual);
		assertEquals(50, new Yatzy(6, 6, 6, 6, 6).yatzy());
		assertEquals(0, new Yatzy(6, 6, 6, 6, 3).yatzy());
	}

	@Test
	public void test_1s() {
		assertTrue(new Yatzy(6, 6, 6, 6, 3).placed_on(1) == 0);
		assertEquals(2, new Yatzy(1, 6, 1, 6, 3).placed_on(1));
		assertEquals(0, new Yatzy(6, 2, 2, 4, 5).placed_on(1));
		assertEquals(0, new Yatzy(6, 2, 2, 4, 5).placed_on(1));

		assertEquals(4, new Yatzy(2, 6, 2, 6, 3).placed_on(2));
		assertEquals(6, new Yatzy(2, 2, 6, 2, 3).placed_on(2));

		assertEquals(6, new Yatzy(1, 2, 3, 2, 3).placed_on(3));
		assertEquals(3, new Yatzy(6, 6, 6, 6, 3).placed_on(3));

		assertEquals(12, new Yatzy(4, 4, 4, 5, 5).placed_on(4));
		assertEquals(8, new Yatzy(4, 4, 5, 5, 5).placed_on(4));
		assertEquals(4, new Yatzy(4, 5, 5, 5, 5).placed_on(4));

		assertEquals(15, new Yatzy(4, 4, 5, 5, 5).placed_on(5));
		assertEquals(20, new Yatzy(4, 5, 5, 5, 5).placed_on(5));

		assertEquals(0, new Yatzy(4, 5, 5, 5, 5).placed_on(6));
		assertEquals(6, new Yatzy(4, 6, 5, 5, 5).placed_on(6));

	}

	@Test
	public void one_pair() {
		assertEquals(6, new Yatzy(3, 3, 3, 5, 6).score_pair());
		assertEquals(10, new Yatzy(5, 3, 3, 3, 5).score_pair());
		assertEquals(12, new Yatzy(3, 3, 6, 6, 5).score_pair());
	}

	@Test
	public void two_Pair() {
		assertEquals(16, new Yatzy(3, 3, 5, 4, 5).two_pair());
		assertEquals(16, new Yatzy(3, 3, 5, 5, 5).two_pair());
		assertEquals(0, new Yatzy(3, 3, 3, 3, 5).two_pair());
	}

	@Test
	public void three_of_a_kind() {
		assertEquals(9, new Yatzy(3, 3, 3, 4, 5).three_of_a_kind());
		assertEquals(15,new Yatzy(5, 3, 5, 4, 5).three_of_a_kind());
		assertEquals(9, new Yatzy(3, 3, 3, 3, 5).three_of_a_kind());
		assertEquals(9, new Yatzy(3, 3, 3, 3, 3).three_of_a_kind());
		assertEquals(0, new Yatzy(3, 3, 2, 2, 1).three_of_a_kind());

	}

	@Test
	public void four_of_a_knd() {
		assertEquals(12, new Yatzy(3, 3, 3, 3, 5).four_of_a_kind());
		assertEquals(20, new Yatzy(5, 5, 5, 4, 5).four_of_a_kind());
		assertEquals(12, new Yatzy(3, 3, 3, 3, 3).four_of_a_kind());
		assertEquals(0, new Yatzy(3, 3, 3, 2, 1).four_of_a_kind());
	}

	@Test
	public void smallStraight() {
		assertEquals(15, new Yatzy(1, 2, 3, 4, 5).smallStraight());
		assertEquals(15, new Yatzy(2, 3, 4, 5, 1).smallStraight());
		assertEquals(0, new Yatzy(1, 2, 2, 4, 5).smallStraight());
		assertEquals(0, new Yatzy(1, 2, 2, 4, 6).smallStraight());
		
	}

	@Test
	public void largeStraight() {
		assertEquals(20, new Yatzy(6, 2, 3, 4, 5).largeStraight());
		assertEquals(20, new Yatzy(3, 4, 5, 6,2).largeStraight());
		assertEquals(20, new Yatzy(2, 3, 4, 5, 6).largeStraight());
		assertEquals(0, new Yatzy(1, 2, 2, 4, 5).largeStraight());
		assertEquals(0, new Yatzy(1, 2, 6, 4, 5).largeStraight());
		assertEquals(20, new Yatzy(5, 3, 6, 4, 2).largeStraight());

		
	}

	@Test
	public void fullHouse() {
		assertEquals(18, new Yatzy(6, 2, 2, 2, 6).fullHouse());
		assertEquals(22, new Yatzy(6, 2, 6, 2, 6).fullHouse());
		assertEquals(28, new Yatzy(5, 5, 6, 6, 6).fullHouse());
		assertEquals(0, new Yatzy(2, 3, 4, 5, 6).fullHouse());
		assertEquals(0, new Yatzy(2, 2, 2, 2, 2).fullHouse());
	}
}
