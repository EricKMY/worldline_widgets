package com.worldline.interview;

public interface IEngine {
    void start();

    void stop();

    boolean isRunning();

    void fill(FuelType fuelType, int fuelLevel);

    double produce(int quantity);

    FuelType getFuelType();
}
