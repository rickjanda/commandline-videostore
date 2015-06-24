import java.util.List;

public class RentalRecord {
    private final List<Rental> rentals;
    private final String customerName;

    public RentalRecord(List<Rental> rentals, String customerName) {
        this.rentals = rentals;
        this.customerName = customerName;
    }

    int getFrequentRenterPoints() {
        int frequentRenterPoints1 = 0;
        for (Rental rental1 : rentals) {
            frequentRenterPoints1 += rental1.getFrequentRenterPoints();
            // show figures for this rental
        }
        return frequentRenterPoints1;
    }

    double getTotalAmount() {
        double totalAmount1 = 0;
        for (Rental rental1 : rentals) {
            totalAmount1 += rental1.getAmount();
        }
        return totalAmount1;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public String getCustomerName() {
        return customerName;
    }
}
