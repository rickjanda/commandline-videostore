public class RentalFactory {
    private MovieRepository movieRepository;

    public RentalFactory(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Rental createFrom(String input) {
        final String[] rentalData = input.split(" ");
        int movieKey = Integer.parseInt(rentalData[0]);
        final Movie movie = movieRepository.getByKey(movieKey);
        return new Rental(movie, Integer.parseInt(rentalData[1]));
    }
}
