package service;

import model.Container;
import model.Device;
import model.SmallContainer;
import model.BigContainer;

import java.util.ArrayList;
import java.util.List;

public class Calculations {
    private final List<Device> devices;
    private final SmallContainer smallContainer;
    private final BigContainer bigContainer;

    public Calculations() {
        devices = new ArrayList<>();
        smallContainer = new SmallContainer();
        bigContainer = new BigContainer();
    }

    public void addItem(Device device) {
        devices.add(device);
    }

    double calculateTotalWeight() {
        return devices.stream().mapToDouble(Device::getWeight).sum();
    }

    double calculateTotalVolume() {
        return devices.stream().mapToDouble(Device::calculateVolume).sum();
    }

    public void calculateContainers() {
        double totalWeight = calculateTotalWeight();
        double totalVolume = calculateTotalVolume();

        int bigContainersCount = calculateContainerCount(totalWeight, totalVolume, bigContainer);
        totalWeight %= bigContainer.getMaxWeight();
        totalVolume %= bigContainer.calculateVolume();

        int smallContainersCount = calculateContainerCount(totalWeight, totalVolume, smallContainer);
        totalWeight %= smallContainer.getMaxWeight();
        totalVolume %= smallContainer.calculateVolume();

        // If there is any remaining weight or volume, allocate one more small container
        if (totalWeight > 0 || totalVolume > 0) {
            smallContainersCount++;
        }

        System.out.println("The optimal shipping method is: " + bigContainersCount + " big containers and " + smallContainersCount + " small containers.");
        System.out.println("The best shipping cost is: " + (bigContainersCount * bigContainer.getPrice() + smallContainersCount * smallContainer.getPrice()) + " Euros.");

    }
    
    private <T extends Container> int calculateContainerCount(double totalWeight, double totalVolume, T container) {
        int countByWeight = (int) (totalWeight / container.getMaxWeight());
        int countByVolume = (int) (totalVolume / container.calculateVolume());
        return Math.min(countByWeight, countByVolume);
    }
}
