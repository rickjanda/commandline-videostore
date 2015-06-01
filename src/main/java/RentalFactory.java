public class RentalFactory {

    private MovieRepository movieRepository;

    public RentalFactory(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;
    }

    Rental createFrom(String input) {
        String[] rental = input.split(" ");
        int movieId = Integer.parseInt(rental[0]);
        Movie movie = movieRepository.getById(movieId);
        int daysRented = Integer.parseInt(rental[1]);

        return new Rental(movie, daysRented);
    }
}
