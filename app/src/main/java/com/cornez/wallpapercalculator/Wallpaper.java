package com.cornez.wallpapercalculator;
/********************place in your main source code as first few lines**********************
 * Name: Uyen Ho
 * Class ID: 3,1
 * Class: CPMS 481
 * Final project : Wallpaper calculator
 * Due Date: 5/27/2020
 * Problem: Calculate how many wall paper rolls user need
 *  Input: user is asked to enter room dimension, door dimension, window dimension and number of doors, windows
 *  Calculation: wall area, unpapered area, wallpapering area are calculated.
 *  Output: the number of wallpaper rolls
 ******************************************************************/

public class Wallpaper {
    //UHo NEW 5/23/2020 5l: usable yield for each pattern repeat
    static final int patternOne = 32;
    static final int patternTwo = 30;
    static final int patternThree = 27;
    static final int patternFour = 25;
    //UHo NEW 5/23/2020 9l: variable for heights, widths, number of doors, number of windows
    double room_height;
    double room_length;
    double room_width;
    double door_height;
    double door_width;
    int doorNumber;
    double window_height;
    double window_width;
    int windowNumbers;
    int usable_yield;
    //UHo NEW 5/23/2020 11l: constructor
    public Wallpaper(){
        room_height = 0.0;
        room_length = 0.0;
        room_width = 0.0;
        door_height = 0.0;
        door_width = 0.0;
        doorNumber = 0;
        window_height = 0.0;
        window_width = 0.0;
        windowNumbers = 0;
        usable_yield = 0;
    }
    //UHo MOD 5/23/2020 10l: set functions if else using the operator conditional ?:
    public void setRoom_height(double h){ room_height = h < 0 ? 0 : h;}
    public void setRoom_length(double l){room_length = l < 0? 0 : l;}
    public void setRoom_width(double w){room_width = w < 0? 0 : w;}
    public void setDoor_height(double h){door_height = h < 0 ? 0 : h; }
    public void setDoor_width(double w){door_width = w < 0? 0 : w;}
    //UHo MOD 5/23/2020 1l: set doorNumber to 1 if n is less than or equal 0
    public void setDoorNumber(int n){doorNumber = n <= 0? 1 : n;}
    public void setWindow_height(double h){window_height = h < 0 ? 0 : h;}
    public void setWindow_width(double w){window_width = w < 0? 0 : w;}
    public void setWindowNumbers(int n){windowNumbers = n < 0? 0 : n;}

    public double getRoom_height(){return room_height;}
    public double getRoom_length(){return room_length;}
    public double getRoom_width(){return room_width;}
    public double getDoor_height(){return door_height;}
    public double getDoor_width(){return door_width;}
    public int getDoorNumber(){return doorNumber;}
    public double getWindow_height(){return window_height;}
    public double getWindow_width(){return window_width;}
    public int getWindowNumbers(){return windowNumbers;}

    //UHo MOD 5/23/2020 3l: Calculate wall area of four walls not include the ceiling floor
    public double wall_area(){
        double total_length = (room_length * 2) + (room_width * 2);
        return (room_height*total_length);
    }
    //UHo MOD 5/23/2020 5l: calculate door areas and windows area that would not need to be cover with wallpaper
    public double unpapered_area(){
        double door_area = (door_height * door_width) * doorNumber;
        double window_area = (window_height * window_width) * windowNumbers;
        return door_area + window_area;
    }
    //UHo MOD 5/23/2020 2l: calculate area that wallpaper covers
    public double wallpaper_area(){
        return wall_area() - unpapered_area();
    }
    //UHo NEW 5/23/2020 2l: calculate how many rolls user needs
    public int rolls(){
        return (int) Math.round(wallpaper_area() / usable_yield);
    }
    //UHo NEW 5/23/2020 2l: find usable yield base on pattern repeat
    public void setPattern(int p){
        usable_yield = p;
    }
}
