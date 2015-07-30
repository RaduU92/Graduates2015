package com.endava.graduates.trainings.mocking.mocks;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StringTransformer.class)
public class StringTransformerTestCase {

	@InjectMocks
	StringTransformer testClass;
	
	@Mock
	MockClass mockClass;
	
	@Before
	public void setUp() throws Exception {
		testClass = new StringTransformer();
		PowerMockito.when(mockClass.transformToUpperCase(Mockito.anyString())).thenReturn("mock");
		PowerMockito.whenNew(MockClass.class).withNoArguments().thenReturn(mockClass);
	}

	@Test
	public void testTransformListToUpperCase() {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		List<String> resultList = testClass.transformListToUpperCase(list);
		assertEquals("mock", resultList.get(0));
	}

}
