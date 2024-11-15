package com.example.CMSC335_Forry1;

import java.awt.*;

public class Shape extends Canvas{
    int NumberOfDimensions;

    public Shape(int n){
        setNumberofDimensions(n);
    }

    //Setters
    public void setNumberofDimensions(int n) {
        this.NumberOfDimensions = n;
    }

    //Getters
    public int getNumberofDimensions() {
        return NumberOfDimensions;
    }

}
