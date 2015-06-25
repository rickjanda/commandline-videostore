public abstract class Rental {
    Movie movie;
    int daysRented;

    protected Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    abstract double getAmount();

    public int getFrequentRenterPoints() {
        return 1;
    }

    public String getMovieName() {
        return movie.getName();
    }
}
