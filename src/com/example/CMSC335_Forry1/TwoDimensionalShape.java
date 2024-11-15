package com.example.CMSC335_Forry1;

public class TwoDimensionalShape extends Shape {
    public TwoDimensionalShape(){
        super(2);
    }
    double area;

    public void setArea(double a) {
        this.area = a;
    }

    public double getArea() {
        return area;
    }
}
