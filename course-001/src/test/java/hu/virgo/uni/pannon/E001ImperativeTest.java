package hu.virgo.uni.pannon;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

public class E001ImperativeTest {

	private static final String filter = "Beat";

	@Test
	public void test() {
		List<Content> albums;
		try (InputStream is = getClass().getResourceAsStream("/albums.json")) {
			JavaType t = TypeFactory.defaultInstance().constructCollectionLikeType(List.class, Content.class);
			ObjectMapper mapper = new ObjectMapper();
			albums = mapper.readValue(is, t);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}

		List<Content> result = new ArrayList<>();
		for (Content c : albums) {
			if (c.getAuthor().contains(filter) && c.getAvailableQuantity() > 0) {
				result.add(c);
			}
		}
		result.sort(new Comparator<Content>() {
			@Override
			public int compare(Content o1, Content o2) {
				return o1.getReleaseYear().compareTo(o2.getReleaseYear());
			}
		});
		out.println(result);
	}
}
