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

    public double calcAmount(Movie movie) {
        double thisAmount = 0;

        //determine amounts for rental
        switch (movie.getType()) {
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
