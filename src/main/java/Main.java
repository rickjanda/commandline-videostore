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
        RentalRecord rentalRecord = new RentalRecord(rentals, customerName);

        String result = "Rental Record for " + rentalRecord.getCustomerName() + "\n";
        for (Rental rental : rentalRecord.getRentals()) {
            result += "\t" + rental.getMovieName() + "\t" + rental.getAmount() + "\n";
        }

        // add footer lines
        result += "You owed " + rentalRecord.getTotalAmount() + "\n";
        result += "You earned " + rentalRecord.getFrequentRenterPoints() + " frequent renter points\n";

        out.print(result);
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
