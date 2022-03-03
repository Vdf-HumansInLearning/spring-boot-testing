package com.vdf.demo.persistence;

import com.vdf.demo.model.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByLastName(String lastName);

    List<Employee> findByLastNameContainingIgnoreCase(String lastName);

    @Query(
        value = "SELECT * FROM employees u WHERE lower(u.last_name) like '%lower(?1)%'",
        nativeQuery = true)
    List<Employee> findEmployeeByLastNameNative(String lastName);
//
//    @Query("select e from Employee e where lower(e.lastName) like %lower(?1)%")
//    List<Employee> findEmployeeByLastNameCaseInsensitive(String lastName);

}
