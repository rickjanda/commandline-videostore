import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class UI {

    private final PrintStream out;
    private final BufferedReader in;
    private final RentalFactory rentalFactory;

    public UI(BufferedReader in, PrintStream out, RentalFactory rentalFactory) {
        this.out = out;
        this.in = in;
        this.rentalFactory = rentalFactory;
    }

    public void outputMovieList(List<Movie> movies1) {
        for (Movie movie : movies1) {
            out.print(movie.getNumber() + ": " + movie.getTitle() + "\n");
        }
    }

    public String inputCustomerName() throws IOException {
        out.print("Enter customer name: ");
        return in.readLine();
    }

    public void outputFooterFor(Customer customer) {
        out.print("You owed " + customer.getTotalAmount() + "\n");
        out.print("You earned " + customer.getFrequentRenterPoints() + " frequent renter points\n");
    }

    public void outputRentalRecordFor(Customer customer) {
        out.print("Rental Record for " + customer.getName() + "\n");
        for (Rental rental : customer.getRentals()) {
            // show figures for this rental
            out.print("\t" + rental.getMovie().getTitle() + "\t" + rental.calcAmount() + "\n");
        }
    }

    public List<Rental> inputRentals() throws IOException {
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
}