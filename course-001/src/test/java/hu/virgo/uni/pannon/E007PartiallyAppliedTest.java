package hu.virgo.uni.pannon;

import org.testng.annotations.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class E007PartiallyAppliedTest {

	private static Function<String, Integer> price = (s) -> IntStream.of(s.chars().map(x -> x - '0').toArray()).sum();

	private static BiFunction<Integer, Boolean, Integer> withToll = (cost, eu) -> cost * (eu ? 1 : 3);


	private static UnaryOperator<Integer> euToll = c -> withToll.apply(c, Boolean.TRUE);

	@Test
	public void test() {
		out.println(
				euToll.compose(price).apply("alma")
		);
		out.println(
				price.andThen(euToll).apply("alma")
		);

		out.println(
				euToll.compose(price).apply("abrak")
		);
		out.println(
				price.andThen(euToll).apply("abrak")
		);
	}
}
