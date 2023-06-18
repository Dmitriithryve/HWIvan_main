package model;

public class BigContainer extends Container {
    public BigContainer() {
        super(2.59, 2.43, 12.01, 1800);
    }

    @Override
    public double calculatePrice(double weight) {
        return getPrice();
    }
}
