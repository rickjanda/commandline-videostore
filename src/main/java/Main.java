import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private final InputStream in;
    private final PrintStream out;

    public static void main(String[] args) throws IOException {
        new Main(System.in, System.out);
    }

    public Main(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    void run() throws IOException {
        final List<Movie> movies = loadMoviesFromFile();

        // output movie list
        for (int movieNumber = 0; movieNumber < movies.size(); ++movieNumber) {
            final Movie movie = movies.get(movieNumber);
            out.print(movieNumber + ": " + movie.getTitle() + "\n");
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
            final Rental rental = Rental.parseFrom(input);
            final Movie movie = movies.get(rental.getMovieNumber());
            double thisAmount = 0;

            //determine amounts for rental
            switch (movie.getType()) {
                case "REGULAR":
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2)
                        thisAmount += (rental.getDaysRented() - 2) * 1.5;
                    break;
                case "NEW_RELEASE":
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                case "CHILDRENS":
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3)
                        thisAmount += (rental.getDaysRented() - 3) * 1.5;
                    break;
            }

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (movie.getType().equals("NEW_RELEASE") && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            // show figures for this rental
            result += "\t" + movie.getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "You owed " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";

        out.print(result);
    }

    private List<Movie> loadMoviesFromFile() throws IOException {
        // read movies from file
        final InputStream movieStream = Main.class.getResourceAsStream("/movies.cvs");
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(movieStream));
        final List<Movie> movies = new ArrayList<>();
        while (bufferedReader.ready()) {
            final String line = bufferedReader.readLine();
            final Movie movie = Movie.parseFrom(line);
            movies.add(movie);
        }
        return movies;
    }

}
