package com.company;

import java.util.HashMap;
import java.util.Map;
public class CowRobotic {

    private int[][] map;

    private int positionX;

    private int positionY;

    private char orientation;

    //Set the combinations of orientation once turn left or right: N:north, W:west, E:east, S:south
    private Map<String,Character> orientationCombinations;


    public CowRobotic(){

        orientationCombinations = new HashMap<>();
        orientationCombinations.put("NI",'E');
        orientationCombinations.put("EI",'S');
        orientationCombinations.put("SI",'O');
        orientationCombinations.put("OI",'N');
        orientationCombinations.put("ND",'O');
        orientationCombinations.put("OD",'S');
        orientationCombinations.put("SD",'E');
        orientationCombinations.put("ED",'N');

    }

    public void setMap(int x, int y){

          this.map = new int[x][y];

    }

    public int getPositionX(){
        return this.positionX;
    }


    public int getPositionY() {
        return positionY;
    }


    public int[][] getMap() {
        return map;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }


    public void changeOrientation(char nextOrientation){

        String key = String.valueOf(this.getOrientation()) +nextOrientation;

        char orientationResult = orientationCombinations.get(key);

        this.orientation = orientationResult;

    }

    public void applyMovement(){

        if (this.orientation=='E') this.positionX--;
        if (this.orientation=='S') this.positionY--;
        if (this.orientation=='O') this.positionX++;
        if (this.orientation=='N') this.positionY++;


    }
}
