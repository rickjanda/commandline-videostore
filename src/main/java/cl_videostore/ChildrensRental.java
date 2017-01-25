package cl_videostore;

public class ChildrensRental extends Rental {

    public ChildrensRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    public double getAmount() {
        if (daysRented > 3) {
            return (daysRented - 2) * 1.5;
        }

        return 1.5;
    }
}
