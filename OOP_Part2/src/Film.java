public class Film {

    private String title;

    public Film(String title) {
        this.title = title;
    }

    public void watchFilm() {
        System.out.println("Watching a film '" + title + "' from '" + this.getClass().getSimpleName() + "' library");
    }

    public static Film createFilmInstance(String library, String title) {
        return switch(library.toUpperCase().charAt(0)) {
            case 'F' -> new Fantasy(title);
            case 'R' -> new Romantic(title);
            default -> new Film(title);
        };
    }
}

class Fantasy extends Film{

    public Fantasy(String title) {
        super(title);
    }
}

class Romantic extends Film{

    public Romantic(String title) {
        super(title);
    }
}
