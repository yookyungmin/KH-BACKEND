
public class Movie {

	
		private String name;
		
		private String genre;
		
		private double score;
		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public double getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public Movie(String name, String genre, Double score) {
			super();
			this.name = name;
			this.genre = genre;
			this.score = score;
		}

		
	

}
