package com.endava.graduates.trainings.patterns;

import org.junit.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by rursu on 7/30/2015.
 */

public class FileContentPatternTestCase {
    private FileContentPattern fileContentPattern;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("setUpBeforeClass");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("tearDownAfterClass");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
        fileContentPattern = new FileContentPattern();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    public void testVerifyContentAgent3() throws Exception {
        String expected = "Secret Agent";
        String actual = fileContentPattern.verifyContent("agent", 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testVerifyContentAgent6() throws Exception {
        String expected =  null;
        String actual = fileContentPattern.verifyContent("agent", 6);
        assertEquals(expected, actual);
    }

    @Test
    public void testVerifyContentSuperAgent6() throws Exception {
        String expected = "Super Secret Agent";
        String actual = fileContentPattern.verifyContent("superAgent", 6);
        assertEquals(expected, actual);
    }


    @Test(expected = Exception.class)
    public void testVerifyContentSuperAgent2() throws Exception {
        fileContentPattern.verifyContent("superAgent", 2);
    }

    @Test
    public void testVerifyContent0() throws Exception {
        String expected = null;
        String actual = fileContentPattern.verifyContent("", 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testVerifyContentNull10() throws Exception {
        String expected = null;
        String actual = fileContentPattern.verifyContent(null, 10);
        assertEquals(expected, actual);
    }
}
