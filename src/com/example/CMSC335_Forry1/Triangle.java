package com.example.CMSC335_Forry1;

public class Triangle extends TwoDimensionalShape {
    //A=((h)b)/2
    public Triangle(double base, double height){
        setArea((base * height) / 2.0);
    }
}
