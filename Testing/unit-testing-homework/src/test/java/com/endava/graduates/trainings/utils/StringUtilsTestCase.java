package com.endava.graduates.trainings.utils;

import com.endava.graduates.trainings.patterns.SuperAgentPattern;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rursu on 7/30/2015.
 */
public class StringUtilsTestCase {
    private StringUtils stringUtils;

    @Before
    public void setUp() throws Exception {
        stringUtils = new StringUtils();
    }

    @Test
    public void testToUpperCase() {
        String expected = "TEST";
        String actual = stringUtils.toUpperCase("test");
        assertEquals(expected, actual);
    }

    @Test
    public void testConcatStrings() {
        String expected = "java test";
        String actual = stringUtils.concatStrings("java ", "test");
        assertEquals(expected, actual);
    }

    @Test
    public void testSubstringValueTest4() {
        String expected = "";
        String actual = stringUtils.substringValue("test", 4);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubstringValueTest2() {
        String expected = "stul";
        String actual = stringUtils.substringValue("testul",2);
        assertEquals(expected, actual);
    }
}
