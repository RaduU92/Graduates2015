package com.endava.graduates.trainings.services;

import com.endava.graduates.trainings.entities.Employee;

public class EmployeeService {

	private static final String POSITION_ARCHITECT = "Architect";
	private static final String POSITION_DEVELOPER = "Developer";
	private static final String POSITION_TESTER = "Tester";
	private static final String DEPARTMENT_ARCHITECTURE = "Architecture";
	private static final String DEPARTMENT_DEVELOPMENT = "Development";
	private static final String DEPARTMENT_TESTING = "Testing";

	public String findDepartmentForEmployee(Employee employee) {
		String department = null;
		if (employee != null) {
			String position = employee.getPosition();
			if (POSITION_ARCHITECT.equalsIgnoreCase(position)) {
				department = DEPARTMENT_ARCHITECTURE;
			} else if (POSITION_DEVELOPER.equalsIgnoreCase(position)) {
				department = DEPARTMENT_DEVELOPMENT;
			} else if (POSITION_TESTER.equalsIgnoreCase(position)) {
				department = DEPARTMENT_TESTING;
			} else if ("analist".equalsIgnoreCase(position)){
				department = "Analysis";
			}
		}
		return department;
	}

}
