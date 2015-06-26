import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Console {

    private final PrintStream out;
    private final RentalFactory rentalFactory;
    private final BufferedReader inputStreamReader;

    public Console(InputStream in, PrintStream out, RentalFactory rentalFactory) {
        this.out = out;
        this.rentalFactory = rentalFactory;
        this.inputStreamReader = new BufferedReader(new InputStreamReader(in));
    }

    public List<Rental> inputRentals() throws IOException {
        out.print("Choose movie by number followed by rental days, just ENTER for bill:\n");
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

    public void printMovies(Collection<Movie> allMovies) {
        for (Movie movie : allMovies) {
            out.print(movie.getKey() + ": " + movie.getName() + "\n");
        }
    }

    public String inputCustomerName() throws IOException {
        out.print("Enter customer name: ");
        return inputStreamReader.readLine();
    }

    public void printFooter(RentalRecord rentalRecord) {
        // add footer lines
        out.print("You owed " + rentalRecord.getTotalAmount() + "\n");
        out.print("You earned " + rentalRecord.getFrequentRenterPoints() + " frequent renter points\n");
    }

    public void printRentalRecord(RentalRecord rentalRecord) {
        out.print("Rental Record for " + rentalRecord.getCustomerName() + "\n");
        for (Rental rental : rentalRecord.getRentals()) {
            out.print("\t" + rental.getMovieName() + "\t" + rental.getAmount() + "\n");
        }
    }
}
