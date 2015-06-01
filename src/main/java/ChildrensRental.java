public class ChildrensRental extends Rental {
    ChildrensRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    double getAmount() {
        double thisAmount = 1.5;

        if (daysRented > 3) {
            thisAmount += (daysRented - 3) * 1.5;
        }

        return thisAmount;
    }
}
