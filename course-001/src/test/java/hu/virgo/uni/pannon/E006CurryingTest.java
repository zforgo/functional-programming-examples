package hu.virgo.uni.pannon;

import org.testng.annotations.Test;

import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

import static java.lang.System.out;

public class E006CurryingTest {

	private static IntBinaryOperator simpleAdd = (a, b) -> a + b;
	private static IntFunction<IntUnaryOperator> curriedAdd = a -> b -> a + b;

	@Test
	public void test() {

		out.println(simpleAdd.applyAsInt(4, 5));

		out.println(curriedAdd.apply(4).applyAsInt(5));

		IntUnaryOperator adder5 = curriedAdd.apply(5);
		out.println(adder5.applyAsInt(4));
		out.println(adder5.applyAsInt(6));
	}
}
