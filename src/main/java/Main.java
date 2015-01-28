import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private final InputStream in;
    private final PrintStream out;

    public static void main(String[] args) throws IOException {
        new Main(System.in, System.out);
    }

    public Main(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    void run() throws IOException {
        final MovieRepository movies = new MovieRepository();
        final RentalFactory rentalFactory = new RentalFactory(movies);

        outputMovieList(movies);

        final BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(in));
        out.print("Enter customer name: ");
        String customerName = inputStreamReader.readLine();

        out.print("Choose movie by number followed by rental days, just ENTER for bill:\n");
        final List<Rental> rentals = inputRentals(rentalFactory, inputStreamReader);
        Customer customer = new Customer(customerName, rentals);

        String result = "Rental Record for " + customer.getName() + "\n";
        for (Rental rental : rentals) {
            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.calcAmount() + "\n";
        }

        // add footer lines
        result += "You owed " + customer.getTotalAmount() + "\n";
        result += "You earned " + customer.getFrequentRenterPoints() + " frequent renter points\n";

        out.print(result);
    }

    private void outputMovieList(MovieRepository movies) {
        for (Movie movie : movies.getAllMovies()) {
            out.print(movie.getNumber() + ": " + movie.getTitle() + "\n");
        }
    }

    private List<Rental> inputRentals(RentalFactory rentalFactory, BufferedReader inputStreamReader) throws IOException {
        final List<Rental> rentals = new ArrayList<>();
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
