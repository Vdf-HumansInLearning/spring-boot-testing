package com.vdf.demo.persistence;

import com.vdf.demo.model.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByLastName(String lastName);

//    @Query(
//        value = "SELECT * FROM employees u WHERE u.last_name = ?1",
//        nativeQuery = true)
//    Employee findEmployeeByStatusNative(Integer status, String i);
//
//    @Query(
//        value = "SELECT * FROM Employee u WHERE u.lastName = ?1")
//    Employee findEmployeeByStatus(Integer status, String i);

}
