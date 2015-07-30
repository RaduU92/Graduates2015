package com.endava.graduates.trainings;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.endava.graduates.trainings.mocking.mocks.StringTransformerTestCase;
import com.endava.graduates.trainings.mocking.spy.StringTransformerSpyTestCase;
import com.endava.graduates.trainings.mocking.stubs.StubTestCase;
import com.endava.graduates.trainings.services.ServicesAllTests;

@RunWith(Suite.class)
@SuiteClasses({ StringTransformerTestCase.class, StringTransformerSpyTestCase.class, StubTestCase.class,
		ServicesAllTests.class })
public class AllTests {

}
