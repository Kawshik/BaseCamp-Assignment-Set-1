package integrated_question13;

public class Movie {
	String id;
	String name;
	float rating;
	String language;
	String genre;
	CastsList castings;

	public Movie(String id, String name, float rating, String language, String genre, CastsList castings) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.language = language;
		this.genre = genre;
		this.castings = castings;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getRating() {
		return rating;
	}

	public String getLanguage() {
		return language;
	}

	public String getGenre() {
		return genre;
	}

	public CastsList getCastings() {
		return castings;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setCastings(CastsList castings) {
		this.castings = castings;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", rating=" + rating + ", language=" + language + ", genre="
				+ genre + ", castings=" + castings + "]";
	}
}
