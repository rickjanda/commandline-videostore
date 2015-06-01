import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Console {

    private PrintStream out;
    private final RentalFactory rentalFactory;
    private BufferedReader inputReader;

    public Console(InputStream in, PrintStream out, RentalFactory rentalFactory) {
        this.out = out;
        this.rentalFactory = rentalFactory;
        this.inputReader = new BufferedReader(new InputStreamReader(in));
    }

    public void print(Iterable<Movie> movies) {
        for (Movie movie : movies) {
            out.print(movie.getId() + ": " + movie.getName() + "\n");
        }
    }

    public void printFooter(RentalRecord rentalRecord) {
        out.print("You owed " + rentalRecord.getTotalAmount() + "\n");
        out.print("You earned " + rentalRecord.getFrequentRenterPoints() + " frequent renter points\n");
    }

    public void print(RentalRecord rentalRecord) {
        out.print("Rental Record for " + rentalRecord.getCustomerName() + "\n");
        for (Rental rental : rentalRecord.getRentals()) {
            out.print("\t" + rental.getMovieName() + "\t" + rental.getAmount() + "\n");
        }
    }

    public String inputCustomerName() throws IOException {
        out.print("Enter customer name: ");
        return inputReader.readLine();
    }

    public ArrayList<Rental> inputRentals() throws IOException {
        out.print("Choose movie by number followed by rental days, just ENTER for bill:\n");

        ArrayList<Rental> rentals = new ArrayList<>();
        while (true) {
            String input = inputReader.readLine();
            if (input.isEmpty()) {
                break;
            }
            Rental rental = rentalFactory.createFrom(input);
            rentals.add(rental);
        }
        return rentals;
    }
}
