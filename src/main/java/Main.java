import java.io.*;
import java.util.ArrayList;

public class Main {

    private final Console console;

    public static void main(String[] args) throws IOException {
        new Main(System.in, System.out).run();
    }

    public Main(InputStream in, PrintStream out) {
        this.console = new Console(in, out);
    }

    void run() throws IOException {
        final MovieRepository movieRepository = new MovieRepository();
        final RentalFactory rentalFactory = new RentalFactory(movieRepository);

        console.print(movieRepository.getAll());

        String customerName = console.inputCustomerName();

        ArrayList<Rental> rentals = console.inputRentals(rentalFactory);

        RentalRecord rentalRecord = new RentalRecord(customerName, rentals);

        console.print(rentalRecord);

        console.printFooter(rentalRecord);

    }

}
