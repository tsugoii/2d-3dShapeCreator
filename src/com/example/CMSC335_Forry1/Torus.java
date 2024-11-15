package com.example.CMSC335_Forry1;

public class Torus extends ThreeDimensionalShape {
//V=(πr^2)(2πR), r=minor radius, R=major radius
    public Torus(double r, double R){
        setVolume((Math.PI * r * r) * (2.0 * Math.PI * R));
    }
}
