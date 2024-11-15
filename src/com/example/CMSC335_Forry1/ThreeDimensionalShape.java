package com.example.CMSC335_Forry1;

public class ThreeDimensionalShape extends Shape{
    public ThreeDimensionalShape(){
        super(3);
    }
    double volume;


    //Setters
    public void setVolume(double v) {
        this.volume = v;
    }

    //Getters
    public double getVolume() {
        return volume;
    }
}
