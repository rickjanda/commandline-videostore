import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private final PrintStream out;
    private final MovieRepository movies;
    private final RentalFactory rentalFactory;
    private final BufferedReader in;

    public static void main(String[] args) throws IOException {
        new Main(System.in, System.out);
    }

    public Main(InputStream in, PrintStream out) throws IOException {
        this.out = out;
        movies = new MovieRepository();
        rentalFactory = new RentalFactory(movies);
        this.in = new BufferedReader(new InputStreamReader(in));
    }

    void run() throws IOException {

        outputMovieList();

        out.print("Enter customer name: ");
        String customerName = in.readLine();

        out.print("Choose movie by number followed by rental days, just ENTER for bill:\n");
        final List<Rental> rentals = inputRentals();
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

    private void outputMovieList() {
        for (Movie movie : movies.getAllMovies()) {
            out.print(movie.getNumber() + ": " + movie.getTitle() + "\n");
        }
    }

    private List<Rental> inputRentals() throws IOException {
        final List<Rental> rentals = new ArrayList<>();
        while (true) {
            String input = in.readLine();
            if (input.isEmpty()) {
                break;
            }
            final Rental rental = rentalFactory.createFrom(input);
            rentals.add(rental);
        }
        return rentals;
    }

}
