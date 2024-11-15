package com.example.CMSC335_Forry1;

public class Circle extends TwoDimensionalShape {
    //A=πr^2
    public Circle(double radius){
        setArea(Math.PI * (radius * radius));
    }
}
