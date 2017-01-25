package cl_videostore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private final InputStream in;
    private final PrintStream out;
    private final MovieRepository movieRepository;
    private final RentalFactory rentalFactory;

    public static void main(String[] args) throws IOException {
        new Main(System.in, System.out).run();
    }

    public Main(InputStream in, PrintStream out) throws IOException {
        this.in = in;
        this.out = out;
        movieRepository = new MovieRepository();
        rentalFactory = new RentalFactory(movieRepository);
    }

    void run() throws IOException {

        for (Movie movie : movieRepository.getAllMovies()) {
            out.print(movie.getKey() + ": " + movie.getName() + "\n");
        }

        final BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(in));
        out.print("Enter customer name: ");
        String customerName = inputStreamReader.readLine();

        out.print("Choose movie by number followed by rental days, just ENTER for bill:\n");

        List<Rental> rentals = inputRentals(inputStreamReader);
        int frequentRenterPoints = getFrequentRenterPoints(rentals);
        double totalAmount = getTotalAmount(rentals);

        String result = "cl_videostore.Rental Record for " + customerName + "\n";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovieName() + "\t" + rental.getAmount() + "\n";
        }

        // add footer lines
        result += "You owed " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";

        out.print(result);
    }

    private double getTotalAmount(List<Rental> rentals) {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.getAmount();
        }
        return totalAmount;
    }

    private int getFrequentRenterPoints(List<Rental> rentals) {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
            // show figures for this rental
        }
        return frequentRenterPoints;
    }

    private List<Rental> inputRentals(BufferedReader inputStreamReader) throws IOException {
        List<Rental> rentals = new ArrayList<>();
        while (true) {
            String input = inputStreamReader.readLine();
            if (input.isEmpty()) {
                break;
            }
            final Rental rental = rentalFactory.createFrom(input);
            rentals.add(rental);
        }
        return rentals;
    }

}
