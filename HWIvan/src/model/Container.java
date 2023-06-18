package model;

public abstract class Container {
    private final double width;
    private final double length;
    private final double height;
    private double maxWeight;
    private final double price;

    Container(double width, double length, double height, double price) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.price = price;
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

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getPrice() {
        return price;
    }

    public double calculateVolume() {
        return getWidth() * getLength() * getHeight();
    }

    public abstract double calculatePrice(double weight);
}
