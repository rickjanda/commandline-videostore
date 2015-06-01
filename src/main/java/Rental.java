public class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }


    double getAmount() {
        double thisAmount = 0;
        switch (movie.getType()) {
            case "REGULAR":
                thisAmount += 2;
                if (daysRented > 2) {
                    thisAmount += (daysRented - 2) * 1.5;
                }
                break;
            case "NEW_RELEASE":
                thisAmount += daysRented * 3;
                break;
            case "CHILDRENS":
                thisAmount += 1.5;
                if (daysRented > 3) {
                    thisAmount += (daysRented - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }

    int getFrequentRenterPoints() {
        // add frequent renter points
        int points = 1;
        // add bonus for a two day new release rental
        if (movie.getType().equals("NEW_RELEASE") && daysRented > 1) {
            points++;
        }
        return points;
    }

    String getMovieName() {
        return movie.getName();
    }
}
