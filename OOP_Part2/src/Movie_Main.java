public class Movie_Main { // Polymorphism

    public static void main(String[] args) {
//        Movie movie = new Movie("Home Alone");
//        movie.watchMovie();
//
//        Movie adventureMovie = new Adventure("Adventure 0");
//        adventureMovie.watchMovie();
//
//        Comedy comedyOne = new Comedy("Funny"); // Access: Can access all methods and fields of both Movie and Comedy.
//                                                    // This includes any methods or fields that are unique to Comedy.
//        comedyOne.watchMovie();
//
//        Movie comedyTwo = new Comedy("Funny"); // Access: Can only access methods and fields that are defined in Movie
//                                                    // (or overridden in Comedy). Any methods or fields unique to Comedy
//                                                    // cannot be accessed through this reference.
//        comedyTwo.watchMovie();

        Movie theMovie = Movie.getMovie("Adventure", "Adventure Movie");
        theMovie.watchMovie();
    }
}
