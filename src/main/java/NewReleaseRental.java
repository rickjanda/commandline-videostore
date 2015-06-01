public class NewReleaseRental extends Rental {
    NewReleaseRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    int getFrequentRenterPoints() {
        if ( daysRented > 1) {
            return 2;
        }
        return 1;
    }

    @Override
    double getAmount() {

        return (double) daysRented * 3;
    }
}
