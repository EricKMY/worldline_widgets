package com.worldline.interview;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class InternalCombustionEngineTest {

    WidgetMachine widgetMachine;
    IEngine internalCombustionEngine;

    @BeforeEach
    public void setUp() {
        internalCombustionEngine = new InternalCombustionEngine(FuelType.PETROL);
        widgetMachine = new WidgetMachine(internalCombustionEngine);
    }

    @Test
    public void zero_widgets_with_petrol_fuel() {
        internalCombustionEngine.fill(FuelType.PETROL, 1);
        assertEquals(0, widgetMachine.produceWidgets(0));
    }

    @Test
    public void eight_widgets_with_petrol_fuel() {
        internalCombustionEngine.fill(FuelType.PETROL, 1);
        assertEquals(9, widgetMachine.produceWidgets(8));
    }


    @Test
    public void sixteen_widgets_with_petrol_fuel() {
        internalCombustionEngine.fill(FuelType.PETROL, 1);
        assertEquals(18, widgetMachine.produceWidgets(16));
    }

    @Test
    public void one_widgets_with_diesel_fuel() {
        internalCombustionEngine = new InternalCombustionEngine(FuelType.DIESEL);
        widgetMachine = new WidgetMachine(internalCombustionEngine);
        internalCombustionEngine.fill(FuelType.DIESEL, 1);
        assertEquals(12, widgetMachine.produceWidgets(1));
    }

    @Test
    public void exception_for_fuel_type_error() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> new InternalCombustionEngine(FuelType.COAL));
        assertEquals("Steam Engine can only be filled with PETROL or DIESEL.", exception.getMessage());

        exception = assertThrows(IllegalStateException.class, () -> new InternalCombustionEngine(FuelType.WOOD));
        assertEquals("Steam Engine can only be filled with PETROL or DIESEL.", exception.getMessage());
    }

    @Test
    public void exception_for_fuel_under_zero() {
        internalCombustionEngine.fill(FuelType.PETROL, 0);
        Throwable exception = assertThrows(IllegalStateException.class, () -> widgetMachine.produceWidgets(1));
        assertEquals("Fuel level under zero, not able to start engine.", exception.getMessage());

        internalCombustionEngine.fill(FuelType.PETROL, -1);
        exception = assertThrows(IllegalStateException.class, () -> widgetMachine.produceWidgets(1));
        assertEquals("Fuel level under zero, not able to start engine.", exception.getMessage());
    }

    @Test
    public void exception_for_filled_type_differ() {
        internalCombustionEngine.fill(FuelType.DIESEL, 1);
        Throwable exception = assertThrows(IllegalStateException.class, () -> widgetMachine.produceWidgets(1));
        assertEquals("Filled type is not same as require type, not able to start engine.", exception.getMessage());
    }
}
