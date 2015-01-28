public class Rental {
    private int movieNumber;
    private int daysRented;

    public Rental(int movieNumber, int daysRented) {
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
