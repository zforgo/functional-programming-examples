package hu.virgo.uni.pannon;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.function.Supplier;

final class Utils {
	static Supplier<List<Content>> albums = () -> {
		try (InputStream is = E002FunctionalTest.class.getResourceAsStream("/albums.json")) {
			JavaType t = TypeFactory.defaultInstance().constructCollectionLikeType(List.class, Content.class);
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(is, t);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}

	};

}
