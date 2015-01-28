public class Rental {
    private int movieNumber;
    private int daysRented;

    public static Rental parseFrom(String input) {
        final String[] rentalTokens = input.split(" ");
        return new Rental(Integer.parseInt(rentalTokens[0]), Integer.parseInt(rentalTokens[1]));
    }

    Rental(int movieNumber, int daysRented) {
        this.movieNumber = movieNumber;
        this.daysRented = daysRented;
    }

    public int getMovieNumber() {
        return movieNumber;
    }

    public int getDaysRented() {
        return daysRented;
    }
}
