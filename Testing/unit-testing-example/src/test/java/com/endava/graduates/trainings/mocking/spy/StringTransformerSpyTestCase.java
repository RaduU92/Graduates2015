package com.endava.graduates.trainings.mocking.spy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class StringTransformerSpyTestCase {

	StringTransformerSpy testClass;
	
	@Before
	public void setUp() throws Exception {
		testClass = Mockito.spy(new StringTransformerSpy());
		Mockito.doReturn("spy").when(testClass).transformToUpperCase(Mockito.anyString());
	}

	@Test
	public void testTransformListToUpperCase() {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		List<String> resultList = testClass.transformListToUpperCase(list);
		assertEquals("spy", resultList.get(0));
	}

}
