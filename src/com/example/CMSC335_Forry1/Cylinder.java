package com.example.CMSC335_Forry1;

public class Cylinder extends ThreeDimensionalShape {
    //V=πr^2h

    public Cylinder(double radius, double height) {
        setVolume((Math.PI * (radius * radius)) * height);
    }
}
