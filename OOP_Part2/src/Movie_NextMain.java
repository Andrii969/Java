public class Movie_NextMain {

    public static void main(String[] args) {
//        Movie movie = Movie.createMovieInstance("A", "Jaws");
//        movie.watchMovie();
//
//        Adventure jaws = (Adventure) Movie.createMovieInstance("A", "Jaws"); // casting here
//        jaws.watchMovie();

//        Object comedy = Movie.createMovieInstance("C", "Jaws");
//        comedy.watchMovie(); // The code doesn't compile because the comedy object is declared as Object,
                            // and the Object class does not have a watchMovie method.
                            // When you declare a variable of type Object, the compiler only knows that it is of type Object,
                            // even though you may assign it an instance of a subclass such as Comedy


//        Object comedy = Movie.createMovieInstance("C", "Jaws");
//        comedy.watchComedy(); // The code doesn't compile because the comedy object is declared as Object,
        // and the Object class does not have a watchMovie method.


//        Object comedy = Movie.createMovieInstance("C", "Jaws"); // The object created by createMovieInstance is initially stored in an Object reference.
//        Comedy comedyMovie = (Comedy) comedy; //  It is then cast to the Comedy type, enabling the use of Comedy-specific methods.
//        comedyMovie.watchMovie();
//        comedyMovie.watchComedy();

//        var airplane = Movie.createMovieInstance("C", "Airplane");
//        airplane.watchMovie();
////        airplane.watchComedy(); // error here, we need Casting (ether when creating the instance or calling the method)
                                   // The inferred type for comedy will be Movie because the createMovieInstance method returns a Movie object.
                                    // Even though the actual instance created is of type Comedy, the variable comedy is still
                                    // considered to be of type Movie.
//
//        var plane = new Comedy("Comedy Plain");
//        plane.watchMovie();
//        plane.watchComedy();

        Object unknownObject = Movie.createMovieInstance("S", "Airplane");
        if (unknownObject.getClass().getSimpleName() == "Comedy") {
            Comedy c = (Comedy) unknownObject; // reason to cast, is to be able to execute any Comedy method
            c.watchComedy(); // Watching a Comedy
        } else if (unknownObject instanceof Adventure) { // checking if unknownObject is an Adventure object
            ((Adventure) unknownObject).watchAdventure();
        } else if (unknownObject instanceof ScienceFiction syfy) { // if object matches the type, assign this object to the variable
            syfy.watchScienceFiction();
        }



    }
}
