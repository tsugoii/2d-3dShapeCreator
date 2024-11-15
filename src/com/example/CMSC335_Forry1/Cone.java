package com.example.CMSC335_Forry1;

public class Cone extends ThreeDimensionalShape {
//V=(πr^2)(h/3)

    public Cone(double radius, double height){
        setVolume((Math.PI * radius * radius) * (height/3.0));
    }
}
