package com.worldline.interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SteamEngineTest {
    WidgetMachine widgetMachine;
    IEngine steamEngine;

    @BeforeEach
    public void setUp() {
        steamEngine = new SteamEngine(FuelType.WOOD);
        widgetMachine = new WidgetMachine(steamEngine);
    }

    @Test
    public void zero_widgets_with_wood_fuel() {
        steamEngine.fill(FuelType.WOOD, 1);
        assertEquals(0, widgetMachine.produceWidgets(0));
    }

    @Test
    public void one_widgets_with_wood_fuel() {
        steamEngine.fill(FuelType.WOOD, 1);
        assertEquals(4.35, widgetMachine.produceWidgets(1));
    }


    @Test
    public void four_widgets_with_wood_fuel() {
        steamEngine.fill(FuelType.WOOD, 1);
        assertEquals(8.7, widgetMachine.produceWidgets(4));
    }

    @Test
    public void two_widgets_with_coal_fuel() {
        steamEngine = new SteamEngine(FuelType.COAL);
        widgetMachine = new WidgetMachine(steamEngine);
        steamEngine.fill(FuelType.COAL, 1);
        assertEquals(5.65, widgetMachine.produceWidgets(2));
    }

    @Test
    public void exception_for_fuel_type_error() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> new SteamEngine(FuelType.PETROL));
        assertEquals("Steam Engine can only be filled with WOOD or COAL.", exception.getMessage());

        exception = assertThrows(IllegalStateException.class, () -> new SteamEngine(FuelType.DIESEL));
        assertEquals("Steam Engine can only be filled with WOOD or COAL.", exception.getMessage());
    }

    @Test
    public void exception_for_fuel_under_zero() {
        steamEngine.fill(FuelType.WOOD, 0);
        Throwable exception = assertThrows(IllegalStateException.class, () -> widgetMachine.produceWidgets(1));
        assertEquals("Fuel level under zero, not able to start engine.", exception.getMessage());

        steamEngine.fill(FuelType.WOOD, -1);
        exception = assertThrows(IllegalStateException.class, () -> widgetMachine.produceWidgets(1));
        assertEquals("Fuel level under zero, not able to start engine.", exception.getMessage());
    }

    @Test
    public void exception_for_filled_type_differ() {
        steamEngine.fill(FuelType.COAL, 1);
        Throwable exception = assertThrows(IllegalStateException.class, () -> widgetMachine.produceWidgets(1));
        assertEquals("Filled type is not same as require type, not able to start engine.", exception.getMessage());
    }
}
