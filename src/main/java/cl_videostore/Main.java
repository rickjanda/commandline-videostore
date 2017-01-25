package cl_videostore;

import java.io.*;

public class Main {

    private final InputStream in;
    private final PrintStream out;
    private final MovieRepository movieRepository;

    public static void main(String[] args) throws IOException {
        new Main(System.in, System.out).run();
    }

    public Main(InputStream in, PrintStream out) throws IOException {
        this.in = in;
        this.out = out;
        movieRepository = new MovieRepository();
    }

    void run() throws IOException {

        for (Movie movie : movieRepository.getAllMovies()) {
            out.print(movie.getKey() + ": " + movie.getName() + "\n");
        }

        final BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(in));
        out.print("Enter customer name: ");
        String customerName = inputStreamReader.readLine();

        out.print("Choose movie by number followed by rental days, just ENTER for bill:\n");

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "cl_videostore.Rental Record for " + customerName + "\n";
        while (true) {
            String input = inputStreamReader.readLine();
            if (input.isEmpty()) {
                break;
            }
            final String[] rentalData = input.split(" ");
            int movieKey = Integer.parseInt(rentalData[0]);
            final Movie movie = movieRepository.getByKey(movieKey);
            final Rental rental = new Rental(movie, Integer.parseInt(rentalData[1]));

            frequentRenterPoints += rental.getFrequentRenterPoints();
            // show figures for this rental
            result += "\t" + rental.getMovieName() + "\t" + rental.getAmount() + "\n";
            totalAmount += rental.getAmount();
        }

        // add footer lines
        result += "You owed " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";

        out.print(result);
    }

}
