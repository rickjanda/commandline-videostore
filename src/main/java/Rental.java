public abstract class Rental {
    protected final Movie movie;
    protected final int daysRented;

    protected Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;

    }


    abstract double getAmount();

    int getFrequentRenterPoints() {
        return 1;
    }

    String getMovieName() {
        return movie.getName();
    }
}
