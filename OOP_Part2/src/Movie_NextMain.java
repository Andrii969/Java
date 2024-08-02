public class Movie_NextMain {

    public static void main(String[] args) {
        Movie movie = Movie.createMovieInstance("A", "Jaws");
        movie.watchMovie();

        Adventure jaws = (Adventure) Movie.createMovieInstance("A", "Jaws"); // casting here
        jaws.watchMovie();

//        Object comedy = Movie.createMovieInstance("C", "Jaws");
//        comedy.watchMovie(); // The code doesn't compile because the comedy object is declared as Object,
                            // and the Object class does not have a watchMovie method.

//        Object comedy = Movie.createMovieInstance("C", "Jaws");
//        comedy.watchComedy(); // The code doesn't compile because the comedy object is declared as Object,
        // and the Object class does not have a watchMovie method.


        Object comedy = Movie.createMovieInstance("C", "Jaws");
        Movie comedyMovie = (Movie) comedy;
        comedyMovie.watchMovie();


    }
}
