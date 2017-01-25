package cl_videostore;

public class NewReleaseRental extends Rental {

    public NewReleaseRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    public int getFrequentRenterPoints() {
        if (daysRented > 1) {
            return 2;
        }
        return 1;
    }

    @Override
    public double getAmount() {
        return daysRented * 3;
    }
}
