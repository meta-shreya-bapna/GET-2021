package employeeOperations;

import java.util.Comparator;

public class NaturalSort implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.emp_id-e2.emp_id;
	}
	
}
