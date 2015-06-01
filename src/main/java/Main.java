import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

public class Main {

    private final Console console;
    private final MovieRepository movieRepository;
    private final RentalFactory rentalFactory;

    public static void main(String[] args) throws IOException {
        new Main(System.in, System.out).run();
    }

    public Main(InputStream in, PrintStream out) throws IOException {
        movieRepository = new MovieRepository();
        rentalFactory = new RentalFactory(movieRepository);
        console = new Console(in, out, rentalFactory);
    }

    void run() throws IOException {

        console.print(movieRepository.getAll());

        String customerName = console.inputCustomerName();
        List<Rental> rentals = console.inputRentals();

        RentalRecord rentalRecord = new RentalRecord(customerName, rentals);

        console.print(rentalRecord);
        console.printFooter(rentalRecord);
    }

}
