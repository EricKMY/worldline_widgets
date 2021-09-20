package com.worldline.interview;

public class WidgetMachine {
    private IEngine engine;

    public WidgetMachine(IEngine engine) {
        this.engine = engine;
    }

    public double produceWidgets(int quantity) {
        double cost = 0;

        engine.start();

        if (engine.isRunning()) {
            cost = engine.produce(quantity);
        }

        engine.stop();

        return cost;
    }
}
