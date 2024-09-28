package TreeSetChallenge;

public class BookingAgent {

    public static void main(String[] args) {

        int rows = 10;
        int totalSeats = 100;
        Theatre rodgersNYC = new Theatre("Richard Rodgers", rows, totalSeats);
        rodgersNYC.printSeatMap();

        bookSeat(rodgersNYC, 'A', 11);

    }

    private static void bookSeat(Theatre theatre, char row, int seatNo) {
//        Theatre.Seat requestedSeat = theatre.new Seat(row, seat);
        String seat = theatre.reserveSeat(row, seatNo);
        if (seat != null) {
            System.out.println("Congratulations! Your reserved seat is " + seat);
            theatre.printSeatMap();
        } else {
            System.out.println("Sorry! Unable to reserve " + row + seatNo);
        }
    }
}
