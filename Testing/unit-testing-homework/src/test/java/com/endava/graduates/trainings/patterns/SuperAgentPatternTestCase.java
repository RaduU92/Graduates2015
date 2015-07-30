package com.endava.graduates.trainings.patterns;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by rursu on 7/30/2015.
 */
public class SuperAgentPatternTestCase {
    private SuperAgentPattern superAgentPattern;

    @Before
    public void setUp() throws Exception {
        superAgentPattern = new SuperAgentPattern();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    public void testCheckIfSuperAgentNull() {
        List<String> inputList = new ArrayList<String>();
        inputList = null;
        boolean expected = false;
        boolean actual = superAgentPattern.checkIfSuperAgent(inputList);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckIfSuperAgentSuperAgent() {
        List<String> inputList = new ArrayList<String>();
        inputList.add("Super Secret Agent");
        boolean expected = true;
        boolean actual = superAgentPattern.checkIfSuperAgent(inputList);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckIfSuperAgentOther() {
        List<String> inputList = new ArrayList<String>();
        inputList.add("Secret Agent");
        inputList.add("Secret Agent 2");
        boolean expected = false;
        boolean actual = superAgentPattern.checkIfSuperAgent(inputList);
        assertEquals(expected, actual);
    }
}
