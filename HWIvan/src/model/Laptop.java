package model;

public class Laptop extends Item {
    public Laptop() {
        super(0.6, 0.5, 0.5, 6.5);
    }

    @Override
    public double calculateVolume() {
        return getWidth() * getLength() * getHeight();
    }
}
