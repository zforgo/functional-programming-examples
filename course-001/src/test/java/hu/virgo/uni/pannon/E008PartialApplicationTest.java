package hu.virgo.uni.pannon;

import org.testng.annotations.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

import static java.lang.System.out;

public class E008PartialApplicationTest {

	private static StringBuilder appendChar(char character, int times, String string) {
		StringBuilder strBuilder = new StringBuilder(string);
		for (int i = 0; i < times; i++) {
			strBuilder.append(character);
		}
		return strBuilder;
	}

	private static Function<String, StringBuilder> addEllipsis = appendToMe -> appendChar('.', 3, appendToMe);

	private static BiFunction<String, Integer, StringBuilder> addBangs = (appendToMe, times) -> appendChar('!', times, appendToMe);

	private static Function<String, StringBuilder> addOneBang = appendToMe -> addBangs.apply(appendToMe, 1);

	@Test
	public void test() {
		out.println(
				addBangs.apply("Java has gone functional", 2)
		);
		out.println(
				addOneBang.apply("Lambdas are sweet")
		);
		out.println(
				addEllipsis.apply("To be continued")
		);
	}
}
