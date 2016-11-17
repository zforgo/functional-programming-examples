package hu.virgo.uni.pannon;

import org.testng.annotations.Test;

import java.util.function.Function;

import static java.lang.System.out;

public class E004CompositionTest {
	private static Function<Integer, Integer> times2 = e -> e * 2;

	private static Function<Integer, Integer> squared = e -> e * e;

	@Test
	public void test() {

		out.println(String.format("andThen: %d",
				times2.andThen(squared).apply(4)
		));


		out.println(String.format("compose: %d",
				times2.compose(squared).apply(4)
		));
	}
}
