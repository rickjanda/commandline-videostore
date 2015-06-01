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

        switch (movie.getType()) {
            case "REGULAR":
                return new RegularRental(movie, daysRented);
            case "NEW_RELEASE":
                return new NewReleaseRental(movie, daysRented);
            case "CHILDRENS":
                return new ChildrensRental(movie, daysRented);
            default:
                throw new RuntimeException("Illegal movie type: " + movie.getType());
        }
    }
}
