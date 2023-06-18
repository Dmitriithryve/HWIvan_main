package model;

public abstract class Item {
    private final double width;
    private final double length;
    private final double height;
    private final double weight;

    Item(double width, double length, double height, double weight) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.weight = weight;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public abstract double calculateVolume();
}
