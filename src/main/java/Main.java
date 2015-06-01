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
            final String[] rental = input.split(" ");

            int movieId = Integer.parseInt(rental[0]);
            Rental rental2 = new Rental(movieRepository.getById(movieId), Integer.parseInt(rental[1]));

            frequentRenterPoints += rental2.getFrequentRenterPoints();
            // show figures for this rental
            result += "\t" + rental2.getMovieName() + "\t" + rental2.getAmount() + "\n";
            totalAmount += rental2.getAmount();
        }

        // add footer lines
        result += "You owed " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";

        out.print(result);
    }

}
