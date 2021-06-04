package com.digite.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class TestParkingSlot {

    static ParkingSlot slot;

    @BeforeAll
    public static void setup() {
        slot = new ParkingSlot(10);
    }

    @Test
    public void testParkFirstCar() throws Exception {
        Car car = new Car("MH 02 123456", "Black");
        slot.parkCar(1, car);
        HashMap<Integer, Car> parkedCars = slot.getParkedCars();
        Assertions.assertEquals(1, parkedCars.get(1).getParkingSlot());
    }

    @Test
    public void testParkSecondCarAtFullSlot() {
        Car car = new Car("MH 02 123457", "White");

        try {
            slot.parkCar(1, car);
        } catch (Exception e) {
            Assertions.assertEquals("Slot 1 is already full", e.getMessage());
        }
    }
}
