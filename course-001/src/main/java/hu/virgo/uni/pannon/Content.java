package hu.virgo.uni.pannon;

import java.io.Serializable;
import java.time.Year;

public class Content implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	private String author;
	private int availableQuantity;
	private Year releaseYear;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Year getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Year releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Override
	public String toString() {
		return "\nContent{" +
				"title='" + title + '\'' +
				", author='" + author + '\'' +
				", availableQuantity=" + availableQuantity +
				", releaseYear=" + releaseYear +
				"}";
	}
}
