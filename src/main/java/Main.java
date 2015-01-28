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

        final String customerName = inputCustomerName();
        final List<Rental> rentals = inputRentals();
        final Customer customer = new Customer(customerName, rentals);

        outputRentalRecord(rentals, customer);
        outputFooter(customer);
    }

    private void outputFooter(Customer customer) {
        out.print("You owed " + customer.getTotalAmount() + "\n");
        out.print("You earned " + customer.getFrequentRenterPoints() + " frequent renter points\n");
    }

    private void outputRentalRecord(List<Rental> rentals, Customer customer) {
        out.print("Rental Record for " + customer.getName() + "\n");
        for (Rental rental : rentals) {
            // show figures for this rental
            out.print("\t" + rental.getMovie().getTitle() + "\t" + rental.calcAmount() + "\n");
        }
    }

    private List<Rental> inputRentals() throws IOException {
        out.print("Choose movie by number followed by rental days, just ENTER for bill:\n");
        final List<Rental> rentals = new ArrayList<>();
        while (true) {
            String input = in.readLine();
            if (input.isEmpty()) {
                break;
            }
            rentals.add(rentalFactory.createFrom(input));
        }
        return rentals;
    }

    private String inputCustomerName() throws IOException {
        out.print("Enter customer name: ");
        return in.readLine();
    }

    private void outputMovieList() {
        for (Movie movie : movies.getAllMovies()) {
            out.print(movie.getNumber() + ": " + movie.getTitle() + "\n");
        }
    }

}
