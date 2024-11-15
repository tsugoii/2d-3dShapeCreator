package com.example.CMSC335_Forry1;

public class Sphere extends ThreeDimensionalShape {
    //V=(4/3)(πr^3)

    public Sphere(double radius) {
        setVolume((4.0 / 3.0) * (Math.PI * (radius * radius)));
    }
}
