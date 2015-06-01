import java.io.*;

public class Main {

    private final InputStream in;
    private final PrintStream out;

    public static void main(String[] args) throws IOException {
        new Main(System.in, System.out).run();
    }

    public Main(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    void run() throws IOException {
        final MovieRepository movieRepository = new MovieRepository();
        final RentalFactory rentalFactory = new RentalFactory(movieRepository);

        for (Movie movie : movieRepository.getAll()) {
            out.print(movie.getId() + ": " + movie.getName() + "\n");
        }

        final BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(in));
        out.print("Enter customer name: ");
        String customerName = inputStreamReader.readLine();

        out.print("Choose movie by number followed by rental days, just ENTER for bill:\n");

        RentalRecord rentalRecord = new RentalRecord(customerName);
        while (true) {
            String input = inputStreamReader.readLine();
            if (input.isEmpty()) {
                break;
            }
            rentalRecord.add(rentalFactory.createFrom(input));
        }

        String result = "Rental Record for " + rentalRecord.getCustomerName() + "\n";
        for (Rental rental : rentalRecord.getRentals()) {
            result += "\t" + rental.getMovieName() + "\t" + rental.getAmount() + "\n";
        }

        // add footer lines
        result += "You owed " + rentalRecord.getTotalAmount() + "\n";
        result += "You earned " + rentalRecord.getFrequentRenterPoints() + " frequent renter points\n";

        out.print(result);
    }

}
