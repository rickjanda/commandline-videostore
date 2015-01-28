public class RentalFactory {

    private final MovieRepository movies;

    public RentalFactory(MovieRepository movies) {

        this.movies = movies;
    }

    public Rental createFrom(String input) {
        final String[] rentalTokens = input.split(" ");
        final int movieNumber = Integer.parseInt(rentalTokens[0]);
        final int daysRented = Integer.parseInt(rentalTokens[1]);
        final Movie movie = movies.getMovieBy(movieNumber);

        return new Rental(daysRented, movie);
    }
}
