package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CowRoboticExecutionTest {

    CowRobotic cowRobotic;

    @Before
    public void setUp() throws Exception {
        cowRobotic = new CowRobotic();
    }


    @Test
    public void setMapTest(){
        String line ="5 4";
        CowRoboticExecution.setMap(line, cowRobotic);
        Assert.assertEquals(cowRobotic.getMap().length, 5);
        Assert.assertEquals(cowRobotic.getMap()[0] .length, 4);

    }

    @Test
    public void setPositionTest(){
        String line ="1 2 N";

        CowRoboticExecution.setPosition(line, cowRobotic);

        Assert.assertEquals(cowRobotic.getPositionX(), 1);
        Assert.assertEquals(cowRobotic.getPositionY(), 2);
        Assert.assertEquals(cowRobotic.getOrientation(), 'N');

    }

    @Test
    public void executeInstructionsTest(){
        String mapSize ="5 5";
        String initialCoordinate="1 2 N";
        String instruction = "IMIMIMIMM";

        CowRoboticExecution.setMap(mapSize, cowRobotic);
        CowRoboticExecution.setPosition(initialCoordinate, cowRobotic);
        CowRoboticExecution.executeInstructions(instruction, cowRobotic);
        String expectedResult = "1 3 N";

        Assert.assertEquals(expectedResult,CowRoboticExecution.getStatusCowRobotic(cowRobotic));

    }

    @Test
    public void isRight(){
        Assert.assertTrue(CowRoboticExecution.isRight('D'));
    }

    @Test
    public void isLeft(){
        Assert.assertTrue(CowRoboticExecution.isLeft('I'));
    }

    @Test
    public void isMovementTest(){
        Assert.assertTrue(CowRoboticExecution.isMovement('M'));
    }
}