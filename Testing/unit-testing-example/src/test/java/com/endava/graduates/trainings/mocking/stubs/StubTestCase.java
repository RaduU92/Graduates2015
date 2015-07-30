package com.endava.graduates.trainings.mocking.stubs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.endava.graduates.trainings.mocking.stubs.RealImplementation;
import com.endava.graduates.trainings.mocking.stubs.StubInterface;

public class StubTestCase {

	StubInterface testClass;

	@Test
	public void testRealMethod() {
		testClass = new RealImplementation();
		List<String> list = new ArrayList<String>();
		list.add("abc");
		List<String> resultList = testClass.execute(list);
		assertEquals("ABC", resultList.get(0));
	}

	@Test
	public void testStubMethod() {
		testClass = new StubImplementation();
		List<String> list = new ArrayList<String>();
		list.add("abc");
		List<String> resultList = testClass.execute(list);
		assertEquals("stub", resultList.get(0));
	}

}
