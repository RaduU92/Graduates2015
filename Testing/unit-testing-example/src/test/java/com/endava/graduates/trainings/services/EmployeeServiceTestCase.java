package com.endava.graduates.trainings.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.endava.graduates.trainings.entities.Employee;
import com.endava.graduates.trainings.services.EmployeeService;

public class EmployeeServiceTestCase {

	private EmployeeService employeeService;
	private Employee employee;
	
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
		employeeService = new EmployeeService();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void testFindDepartmentForEmployeeWithEmployeeNull() {
		System.out.println("test");
		employee = null;
		String actual = employeeService.findDepartmentForEmployee(employee);
		assertNull(actual);
	}

	@Test
	public void testFindDepartmentForEmployeeWithEmployeeNotNull() {
		System.out.println("test");
		employee = new Employee("", "", "");
		String actual = employeeService.findDepartmentForEmployee(employee);
		assertNull(actual);
	}

	@Test
	public void testFindDepartmentForEmployeeWithEmployeePositionDeveloper() {
		System.out.println("test");
		employee = new Employee("", "", "developer");
		String actual = employeeService.findDepartmentForEmployee(employee);
		String expected = "Development";
		assertEquals(expected, actual);
	}
	
	//@Test(expected = NullPointerException.class) // if you expect an Exception
	@Test
	public void testAnalysis(){
		employee = new Employee("", "", "analist");
		String actual = employeeService.findDepartmentForEmployee(employee);
		String expected = "Analysis";
		assertEquals(expected, actual);
	}
	
}
