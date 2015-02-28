import java.io.*;
import java.util.List;

public class Main {

    private final MovieRepository movies;
    private final UI ui;


    public static void main(String[] args) throws IOException {
        new Main(System.in, System.out);
    }

    public Main(InputStream in, PrintStream out) throws IOException {
        movies = new MovieRepository();
        RentalFactory rentalFactory = new RentalFactory(movies);
        ui = new UI(new BufferedReader(new InputStreamReader(in)), out, rentalFactory);
    }

    void run() throws IOException {

        ui.outputMovieList(movies.getAllMovies());

        final String customerName = ui.inputCustomerName();
        final List<Rental> rentals = ui.inputRentals();
        final Customer customer = new Customer(customerName, rentals);

        ui.outputRentalRecordFor(customer);
        ui.outputFooterFor(customer);
    }
}
