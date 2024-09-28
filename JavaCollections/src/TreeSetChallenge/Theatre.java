package TreeSetChallenge;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Theatre {

    class Seat implements Comparable<Seat> {

        private String seatNum;
        private boolean reserved;

        public Seat (char rowChar, int seatNo) {
            this.seatNum = "%c%03d".formatted(rowChar, seatNo).toUpperCase();
            // "%03d": This format specifier is used to insert an integer.
            // The 03 indicates that the integer should be formatted as a three-digit number, with leading zeros if necessary.
            // For example, if seatNo is 5, it will be formatted as 005.
        }

        @Override
        public int compareTo(Seat o) {
            return seatNum.compareTo(o.seatNum);
        }

        @Override
        public String toString() {
            return seatNum;
        }
    }

    private String theatreName;
    private int seatsPerRow;
    private NavigableSet<Seat> seats;
    // So why did I use NavigableSet, and not SortedSet or TreeSet? First of all, when using a class in the collection's framework,
    // you'll use the interface type as your reference type, so you don't want to use TreeSet. I'm planning on using methods specifically declared
    // on NavigableSet, that aren't on SortedSet, such as the floor and ceiling methods, so that's why I'm going with this type.

    public Theatre(String theatreName, int rows, int totalSeats) {
        this.theatreName = theatreName;
        this.seatsPerRow = totalSeats / rows;

        seats = new TreeSet<>();
        for (int i = 0; i < totalSeats; i++) {
            // Calculate the row character (A, B, C, ...) based on the seat index
            char rowChar = (char) (i / seatsPerRow + (int) 'A');
            // Calculate the seat number in the current row (1-based index)
            int seatInRow = i % seatsPerRow + 1;
            // Create a new Seat object and add it to the seats set
            seats.add(new Seat(rowChar, seatInRow));
        }
    }

    public void printSeatMap() {
        String separatorLine = "-".repeat(90);
        System.out.printf("%1$s%n%2$s Seat Map%n%1$s%n", separatorLine, theatreName);
        int index = 0;
        // Iterate through each seat in the seats set to print the seat map
        for (Seat s : seats) {
            // Print seat number and reserved status, with a new line at the end of each row
            System.out.printf("%-8s%s", s.seatNum + ((s.reserved) ? "(\u25CF)" : ""),
                    ((index++ + 1) % seatsPerRow == 0) ? "\n" : "");
        }
        System.out.println(separatorLine);
    }

    public String reserveSeat(char row, int seat) {
        Seat requestedSeat = new Seat(row, seat);
        Seat requested = seats.floor(requestedSeat);
        if (requested == null || !requested.seatNum.equals(requestedSeat.seatNum)) {
            System.out.print("No such seat: " + requestedSeat);
            System.out.printf(": Seat must be between %s and %s%n", seats.first().seatNum, seats.last().seatNum);
        } else {
            if (!requested.reserved) {
                requested.reserved = true;
                return requested.seatNum;
            } else {
                System.out.println("Seat's already reserved.");
            }
        }

        return null;
    }

}
