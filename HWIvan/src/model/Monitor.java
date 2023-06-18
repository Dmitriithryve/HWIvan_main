package model;

public class Monitor extends Device {
    public Monitor() {
        super(1.2, 1.4, 0.8, 2.6);
    }

    @Override
    public double calculateVolume() {
        return getWidth() * getLength() * getHeight();
    }
}
