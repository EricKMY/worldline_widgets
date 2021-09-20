package com.worldline.interview;

public abstract class Engine implements IEngine {
    private boolean running;
    private int fuelLevel;
    private FuelType requiredFuelType;
    private FuelType fuelType;

    public Engine(FuelType requiredFuelType) {
        this.requiredFuelType = requiredFuelType;
        running = false;
        fuelLevel = 0;
    }

    public void start() {
        if (fuelLevel > 0 && requiredFuelType.equals(fuelType)) {
            running = true;
        }else if(fuelLevel <=0 ) {
            throw new IllegalStateException("Fuel level under zero, not able to start engine.");
        }else {
            throw new IllegalStateException("Filled type is not same as require type, not able to start engine.");
        }
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void fill(FuelType fuelType, int fuelLevel) {
        if (fuelLevel > 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        }
        else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        }
        else {
            this.fuelLevel = 0;
        }

        this.fuelType = fuelType;
    }

    public FuelType getFuelType() {
        return requiredFuelType;
    }
}
