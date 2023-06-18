package model;

public class SmallContainer extends Container {
    public SmallContainer() {
        super(2.59, 2.43, 6.06, 1000);
        setMaxWeight(1000);
    }

    @Override
    public double calculatePrice(double weight) {
        if (weight <= 500) {
            return 1000;
        } else {
            return 1200;
        }
    }
}
