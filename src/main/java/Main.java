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

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + customerName + "\n";
        while (true) {
            String input = inputStreamReader.readLine();
            if (input.isEmpty()) {
                break;
            }
            Rental rental = rentalFactory.createFrom(input);

            frequentRenterPoints += rental.getFrequentRenterPoints();
            // show figures for this rental
            result += "\t" + rental.getMovieName() + "\t" + rental.getAmount() + "\n";
            totalAmount += rental.getAmount();
        }

        // add footer lines
        result += "You owed " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";

        out.print(result);
    }

}
