package com.worldline.interview;

public class InternalCombustionEngine extends Engine {

    public InternalCombustionEngine(FuelType requiredFuelType) {
        super(requiredFuelType);
        if(!(getFuelType().equals(FuelType.PETROL) || getFuelType().equals(FuelType.DIESEL))) {
            throw new IllegalStateException("Steam Engine can only be filled with PETROL or DIESEL.");
        }
    }

    public double produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        int costPerBatch = 0;

        if (getFuelType() == FuelType.PETROL) {
            costPerBatch = 9;
        } else if (getFuelType() == FuelType.DIESEL) {
            costPerBatch = 12;
        }

        while (batch < quantity) {
            batch += 8;
            batchCount++;
        }

        return batchCount * costPerBatch;
    }

}
