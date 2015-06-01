public class RegularRental extends Rental {
    RegularRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    double getAmount() {
        double thisAmount = 2;
        if (daysRented > 2) {
            thisAmount += (daysRented - 2) * 1.5;
        }

        return thisAmount;
    }
}
