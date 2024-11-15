package com.example.CMSC335_Forry1;

public class Cube extends ThreeDimensionalShape {
//V=a^3

    public Cube(double edgeLength){
        setVolume(edgeLength * edgeLength * edgeLength);
    }
}
