package com.casa.anotation.springmvc.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.casa.anotation.springmvc.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value="SELECT em FROM Employee em "
			+ " INNER JOIN em.office"
			+ " LEFT JOIN em.employee")
	public List<Employee> findAllEmployeesJoinOffice();
	
//	@Query(value="SELECT * FROM employees em "
//			+ "INNER JOIN offices of ON em.officeCode = of.officeCode", nativeQuery = true)
	@Query(value="SELECT em FROM Employee em INNER JOIN em.office LEFT JOIN em.employee")
	public Page<Employee> findAllEmployeesJoinOffice(Pageable pageable);
	
	@Query(value="SELECT em FROM Employee em INNER JOIN em.office LEFT JOIN em.employee WHERE em.employeeNumber = :idEmployee")
	public Employee findEmployeeWithId(@Param("idEmployee") int idEmployee);
	
	@Query(value="SELECT em FROM Employee em INNER JOIN em.office LEFT JOIN em.employee WHERE em.employeeNumber = :idBoss AND em.office.officeCode = :idOffice")
	public Employee findBossWithOfficeCode(@Param("idBoss") int idBoss, @Param("idOffice") String officeCode);
	
}
