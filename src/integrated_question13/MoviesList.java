package integrated_question13;

public class MoviesList {
	Movie[] movies;
	int i;

	public MoviesList() {
		this.movies = new Movie[10];
		this.i = 0;
	}

	public void add(Movie movie) {
		if(i==this.movies.length) resize();
		this.movies[i] = movie;
		i++;
	}

	private void resize() {
		Movie[] newMovies = new Movie[this.movies.length * 2];
		for (int i = 0; i < this.movies.length; i++) {
			newMovies[i] = this.movies[i];
		}
		this.movies = newMovies;
	}

	public void delete(Movie movie) {
		if(this.movies[this.i - 1].getId().equals(movie.getId())) {
			this.movies[i-1] = null;
			this.i--;
			return;
		}
		
		for (int i = 0; i < this.movies.length - 1; i++) {
			if(this.movies[i] != null) {
				if (this.movies[i].getName().equals(movie.getName())) {
					for (int j = i; j < movies.length - 1; j++) {
						movies[j] = movies[j+1];
					}
					
					this.movies[this.i -1] = null;
					this.i--;
				}
			}
		}
		
	}
	
	public Movie[] get() {
		Movie[] movies = new Movie[size()];
		for (int i = 0; i < this.movies.length; i++) {
			if (this.movies[i] != null)
				movies[i] = this.movies[i];
		}
		return movies;
	}

	public int size() {
		return i;
	}
	
	public void print() {
		for (int i = 0; i < this.i; i++) {
			if (this.movies[i] != null)
				System.out.println(this.movies[i]);
		}
	}
}
