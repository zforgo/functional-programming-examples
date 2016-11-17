package hu.virgo.uni.pannon;

import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static hu.virgo.uni.pannon.Utils.albums;
import static java.lang.System.out;

public class E005ComposedPredicateTest {

	private static final String filter = "the";

	private static Predicate<Content> title = c -> c.getTitle().toLowerCase().contains(filter.toLowerCase());
	private static Predicate<Content> author = c -> c.getAuthor().toLowerCase().contains(filter.toLowerCase());


	@Test
	public void test() {
		List<Content> results = albums.get().stream()
				.filter(title.or(author).and(c -> c.getAvailableQuantity() > 0))
				.collect(Collectors.toList());
		out.println(results);
	}
}
