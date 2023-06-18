package model;

public class Mouse extends Device {
    public Mouse() {
        super(0.3, 0.3, 0.2, 0.2);
    }

    @Override
    public double calculateVolume() {
        return getWidth() * getLength() * getHeight();
    }
}
