import java.util.Scanner;

public class Film_Main {

    public static void main(String[] args) {
//        Film theFilm = new Film("Star wars");
//        theFilm.watchFilm();
//
//        Fantasy fantasyFilm = new Fantasy("FantasyMovie");
//        fantasyFilm.watchFilm();
//
//        Romantic romanticFilm = new Romantic("RomanticMovie");
//        romanticFilm.watchFilm();


        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Please, choose the movie library");
            String library = s.nextLine();
            if ("Qq".contains(library)) {
                break;
            }
            System.out.println("Please, type the movie name");
            String title = s.nextLine();
            if ("Qq".contains(title)) {
                break;
            }
            Film theFilm = Film.createFilmInstance(library, title);
            theFilm.watchFilm();
            }
        }
    }
