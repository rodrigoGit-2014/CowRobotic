package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CowRoboticExecution {

    public static void main(String[] args) {

        CowRobotic cowRobotic = new CowRobotic();

        readInstructions(cowRobotic);


    }


    private static void readInstructions(CowRobotic cowRobotic) {
        try {
            try (BufferedReader bufferReaderCow = new BufferedReader(new FileReader("resource/input.txt"))) {

                String line;

                try {
                    int control = 0;
                    //need to include if sentence in order to call only one method by cicle either: setMap or setPosition .....
                    while ((line = bufferReaderCow.readLine()) != null) {

                        if  (control==0) setMap(line, cowRobotic);
                        if  (control==1) setPosition(line, cowRobotic);
                        if  (control==2) executeInstructions(line, cowRobotic);
                        if  (control==3) System.out.println(getStatusCowRobotic(cowRobotic)); //TODO: send to file, meanwhile go to print
                        control++;
                        if (control==4) control=1;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setMap(String line, CowRobotic cowRobotic) {

        String[] arraySplitMap = line.split(" ");

        cowRobotic.setMap(Integer.parseInt(arraySplitMap[0]), Integer.parseInt(arraySplitMap[1]));

    }

    public static void setPosition(String line, CowRobotic cowRobotic) {

        String[] arraySplitMap = line.split(" ");
        cowRobotic.setPositionX(Integer.parseInt(arraySplitMap[0]));
        cowRobotic.setPositionY(Integer.parseInt(arraySplitMap[1]));
        cowRobotic.setOrientation(arraySplitMap[2].charAt(0));

    }

    public static void executeInstructions(String line, CowRobotic cowRobotic) {

        for (int i = 0; i < line.length(); i++) {

            char orientation = line.charAt(i);

            if (isMovement(orientation)) {
                cowRobotic.applyMovement();
            } else {
                cowRobotic.changeOrientation(orientation);
            }

        }


    }


    public static String getStatusCowRobotic(CowRobotic cowRobotic) {
        return cowRobotic.getPositionX() + " " + cowRobotic.getPositionY() + " " + cowRobotic.getOrientation();
    }

    public static boolean isLeft(char movement) {
        return movement == 'I';
    }

    public static boolean isRight(char movement) {
        return movement == 'D';
    }

    public static boolean isMovement(char movement) {
        return movement == 'M';
    }


}
