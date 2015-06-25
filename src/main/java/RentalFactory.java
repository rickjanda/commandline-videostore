public class RentalFactory {
    private MovieRepository movieRepository;

    public RentalFactory(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Rental createFrom(String input) {
        final String[] rentalData = input.split(" ");
        final int movieKey = Integer.parseInt(rentalData[0]);
        final Movie movie = movieRepository.getByKey(movieKey);
        final int daysRented = Integer.parseInt(rentalData[1]);

        switch (movie.getCategory()) {
            case "REGULAR":
                return new RegularRental(movie, daysRented);
            case "NEW_RELEASE":
                return new NewReleaseRental(movie, daysRented);
            case "CHILDRENS":
                return new ChildrensRental(movie, daysRented);
        }

        throw new RuntimeException("Unknown rental category: " + movie.getCategory());
    }
}
