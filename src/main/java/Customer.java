import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals;

    public Customer(String name, List<Rental> rentals) {

        this.name = name;
        this.rentals = rentals;
    }

    public String getName() {
        return name;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : this.rentals) {
            totalAmount += rental.calcAmount();
        }
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : this.rentals) {
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (rental.getMovie().getType().equals("NEW_RELEASE") && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
        }
        return frequentRenterPoints;
    }
}
