package hu.virgo.uni.pannon;

import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static hu.virgo.uni.pannon.Utils.albums;
import static java.lang.System.out;

public class E002FunctionalTest {
	private static final String filter = "Beat";


	@Test
	public void test() {
		List<Content> results = albums.get().stream()
				.filter(a -> a.getAuthor().contains(filter) && a.getAvailableQuantity() > 0)
				.sorted((o1, o2) -> o1.getReleaseYear().compareTo(o2.getReleaseYear()))
				.collect(Collectors.toList());
		out.println(results);
	}
}
