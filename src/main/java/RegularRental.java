public class RegularRental extends Rental {
    public RegularRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    public double getAmount() {

        if (daysRented > 2) {
            return 2 + (daysRented - 2) * 1.5;
        }

        return (double) 2;
    }
}
