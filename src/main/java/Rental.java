public class Rental {
    private final int daysRented;
    private final Movie movie;

    Rental(int daysRented, Movie movie) {
        this.daysRented = daysRented;
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double calcAmount() {
        double thisAmount = 0;

        //determine amounts for rental
        switch (this.movie.getType()) {
            case "REGULAR":
                thisAmount += 2;
                if (getDaysRented() > 2)
                    thisAmount += (getDaysRented() - 2) * 1.5;
                break;
            case "NEW_RELEASE":
                thisAmount += getDaysRented() * 3;
                break;
            case "CHILDRENS":
                thisAmount += 1.5;
                if (getDaysRented() > 3)
                    thisAmount += (getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }
}
