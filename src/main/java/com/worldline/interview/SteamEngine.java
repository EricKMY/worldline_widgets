package com.worldline.interview;

public class SteamEngine extends Engine {

    public SteamEngine(FuelType requiredFuelType) {
        super(requiredFuelType);
        if(!(getFuelType().equals(FuelType.WOOD) || getFuelType().equals(FuelType.COAL))) {
            throw new IllegalStateException("Steam Engine can only be filled with WOOD or COAL.");
        }
    }

    public double produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        double costPerBatch = 0;

        if (getFuelType() == FuelType.WOOD) {
            costPerBatch = 4.35;
        } else if (getFuelType() == FuelType.COAL) {
            costPerBatch = 5.65;
        }

        while (batch < quantity) {
            batch += 2;
            batchCount++;
        }

        return batchCount * costPerBatch;
    }
}
