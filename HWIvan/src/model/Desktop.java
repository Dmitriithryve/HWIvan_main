package model;

public class Desktop extends Item {
    public Desktop() {
        super(1.0, 1.5, 0.5, 20);
    }

    @Override
    public double calculateVolume() {
        return getWidth() * getLength() * getHeight();
    }
}
