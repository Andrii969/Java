public class Movie { // Polymorphism

    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovie() {
        String instanceType = this.getClass().getSimpleName();
        System.out.println(title + " is a " + instanceType + " film");
    }

// In the createMovieInstance method of the Movie class, a factory pattern is implemented.
// This pattern is used to create instances of different subclasses based on the provided type.
// This approach allows for creating different types of movies (Adventure, Comedy, ScienceFiction) without directly
// referencing their constructors outside of this method, promoting loose coupling and enhancing maintainability.

//Class-Level Method: A static method belongs to the class itself rather than to instances of the class.
// This means you can call createMovieInstance without creating an instance of Movie.
// This is useful for factory methods because you often need to create instances of the class
// or its subclasses without having an existing instance.
//Convenience: You can call the createMovieInstance method directly using the class name,
// like Movie.createMovieInstance("A", "Indiana Jones"), without needing to instantiate a Movie object first.
//Instance Independence: Since factory methods are typically used to create objects, it makes sense for
// them to be static because they don't depend on the state of any particular instance of the class.
    public static Movie createMovieInstance(String type, String title) {
        return switch (type.toUpperCase().charAt(0)) {
            case 'A' -> new Adventure(title);
            case 'C' -> new Comedy(title);
            case 'S' -> new ScienceFiction(title);
            default -> new Movie(title);
        };
    }
}

class Adventure extends Movie {

    public void watchAdventure() {
        System.out.println("Watching an Adventure");
    }

    public Adventure(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Adventure 1", "Adventure 2", "Adventure 3");
    }
}

class Comedy extends Movie {

    public void watchComedy() {
        System.out.println("Watching a Comedy");
    }

    public Comedy(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Comedy 1", "Comedy 2", "Comedy 3");
    }
}

class ScienceFiction extends Movie {

    public void watchScienceFiction() {
        System.out.println("Watching a Science Fiction");
    }

    public ScienceFiction(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Science Fiction 1", "Science Fiction 2", "Science Fiction 3");
    }
}

