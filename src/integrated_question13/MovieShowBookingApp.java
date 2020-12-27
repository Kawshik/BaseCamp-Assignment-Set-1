package integrated_question13;

import java.util.Scanner;

import utils.Utils;

public class MovieShowBookingApp {
	MoviesList movies;
	static Scanner sc;

	public MovieShowBookingApp() {
		movies = new MoviesList();
	}

	void printMovies(Movie[] movies) {
		for (int i = 0; i < movies.length; i++) {
			System.out.println(movies[i]);
		}
	}

	Movie searchByName(String name) {
		for (int i = 0; i < this.movies.get().length; i++) {
			if (this.movies.get()[i].getName().equals(name))
				return this.movies.get()[i];
		}
		return null;
	}

	Movie[] searchByLanguage(String language) {
		MoviesList movies = new MoviesList();
		for (int i = 0; i < this.movies.get().length; i++) {
			if (this.movies.get()[i].getLanguage().equals(language))
				movies.add(this.movies.get()[i]);
		}

		return movies.get();
	}

	Movie[] searchByCast(String castName) {
		MoviesList moviesList = new MoviesList();
		Movie[] movies = this.movies.get();
		for (int i = 0; i < movies.length; i++) {
			String[] casts = movies[i].getCastings().get();
			for (int j = 0; j < casts.length; j++) {
				if (casts[j].equals(castName))
					moviesList.add(movies[i]);
			}
		}

		return moviesList.get();
	}

	void createMovies() {
		System.out.println("Enter Movie Id: ");
		String id = sc.nextLine();
		System.out.println("Enter Movie Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Movie Rating: ");
		float rating = Utils.getInputTypeFloat(sc, "Enter a valid Rating...");
		System.out.println("Enter Movie Language: ");
		String language = sc.nextLine();
		System.out.println("Enter Movie Genre: ");
		String genre = sc.nextLine();

		System.out.println("Enter Movie Casts Names: ");
		CastsList castings = new CastsList();
		System.out.println("Enter how many you want to enter...");
		int castListSize = Utils.getInputTypeInt(sc, "Enter a valid Integer...");
		for (int i = 0; i < castListSize; i++) {
			System.out.println("Enter a cast Name: ");
			castings.add(sc.nextLine());
		}

		this.movies.add(new Movie(id, name, rating, language, genre, castings));
	}
	
	
	
	void menu() {
		System.out.println("1. Add Movie Details");
		System.out.println("2. Display Movie Details");
		System.out.println("3. Delete Movie Details");
		
		System.out.println("4. Exit");
	}

	void displayMenu() {
		System.out.println("1. Sorted by id.");
		System.out.println("2. Sorted by rating.");
		System.out.println("3. Search Movie By name.");
		System.out.println("4. Search movie by language.");
		System.out.println("5. Search movie by cast.");
		System.out.println("6. Exit.");
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		MovieShowBookingApp mba = new MovieShowBookingApp();
		
		int opt;
		do {
			mba.menu();
			opt = Utils.getInputTypeInt(sc, "Enter a valid Option...");
			
			switch (opt) {
			case 1:
				System.out.println("Enter how Many Movies you want to add? ");
				int numOfMov = Utils.getInputTypeInt(sc, "Enter a valid Option...");
				for(int i=0;i<numOfMov;i++) {
					mba.createMovies();
				}
				
				break;
			case 2:
				int option;
				do {
					mba.displayMenu();
					option = Utils.getInputTypeInt(sc, "Enter a valid Option...");
					switch (option) {
					case 1:
						mba.printMovies(mba.sortById());
						break;
					case 2:
						mba.printMovies(mba.sortByRating());
						break;
					case 3:
						System.out.println("Enter a movie name: ");
						String name = sc.nextLine();
						System.out.println(mba.searchByName(name));
						break;
					case 4:
						System.out.println("Enter a Language: ");
						String language = sc.nextLine();
						mba.printMovies(mba.searchByLanguage(language));
						break;
					case 5:
						System.out.println("Enter a Cast Name: ");
						String castName = sc.nextLine();
						mba.printMovies(mba.searchByCast(castName));
						break;
					case 6:
						break;
					default:
						break;
					}
				} while(option!=6);
				break;
			case 3:
				System.out.println("Enter a Movie Name:");
				String movieName = sc.nextLine();
				mba.movies.delete(new Movie("", movieName, 0, "", "", new CastsList()));
				break;
			case 4:
				System.out.println("Terminated...");
				break;
			default:
				break;
			}
		} while(opt!=4);
	}

	void addSampleData() {
		CastsList harryPotter = new CastsList();
		harryPotter.add("Daniel Radcliffe");
		harryPotter.add("Emma Watson");
		this.movies.add(new Movie("5", "Harry potter", 5, "English", "Adventure", harryPotter));

		CastsList krish = new CastsList();
		krish.add("Hritik Roshan");
		krish.add("Priyanka Chopra");
		this.movies.add(new Movie("3", "Krish", 3, "Hindi", "Action", krish));

		CastsList avengers = new CastsList();
		avengers.add("Robert Downey Jr.");
		avengers.add("Chris Evans");
		avengers.add("Scarlet Johansson");
		avengers.add("Chris Hemsworth");
		avengers.add("Mark Ruffalo");
		avengers.add("Chadwick Boseman");
		avengers.add("Jeremy Renner");
		avengers.add("Benedict Cumberbatch");
		this.movies.add(new Movie("2", "Avengers", 2, "English", "Action", avengers));

		CastsList thor = new CastsList();
		thor.add("Chris Hemsworth");
		thor.add("Mark Ruffalo");
		this.movies.add(new Movie("4", "Thor", 4, "English", "Action", thor));

		CastsList ironMan = new CastsList();
		ironMan.add("Robert Downey Jr.");
		this.movies.add(new Movie("1", "Iron Man", 1, "English", "Action", ironMan));

		CastsList captain = new CastsList();
		captain.add("Chris Evans");
		this.movies.add(new Movie("6", "Captain America", 3, "English", "Action", captain));
	}

	Movie[] sortById() {
		Movie[] movies = this.movies.get();

		for (int i = 1; i < movies.length; i++) {
			int j = i - 1;
			Movie key = movies[i];

			while (j >= 0 && movies[j].getId().compareTo(key.getId()) > 0) {
				movies[j + 1] = movies[j];
				j--;
			}
			movies[j + 1] = key;
		}

		return movies;
	}

	Movie[] sortByRating() {
		Movie[] movies = this.movies.get();

		MergeSort mg = new MergeSort();
		mg.mergeSort(movies, 0, movies.length - 1);

		return movies;
	}
}
