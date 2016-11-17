package hu.virgo.uni.pannon;


import org.testng.annotations.Test;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static hu.virgo.uni.pannon.Utils.albums;
import static java.lang.System.out;

public class E003DecompositionTest {

	private static final String filter = "the";

	private static UnaryOperator<List<Content>> titleFilter = i -> i.stream()
			.filter(a -> a.getTitle().toLowerCase().contains(filter.toLowerCase()))
			.collect(Collectors.toList());

	private static UnaryOperator<List<Content>> authorFilter = i -> i.stream()
			.filter(a -> a.getAuthor().toLowerCase().contains(filter.toLowerCase()))
			.collect(Collectors.toList());


	@Test
	public void test() {
		List<Content> results = titleFilter.andThen(authorFilter).apply(albums.get());
		out.println(results);
	}

}
