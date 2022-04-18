package com.repository;

import com.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public Employee findByEmail(String email);

    /**
     * 測試學習@Query註解 native
     * nativeQuery = true 為使用原生sql
     * false 為使用JPQL語法
     * @param name
     * @param email
     * @param id
     * @return
     */
    @Query(value = "select name,id,email,age from employee where name = ?1  and id = ?2",
            nativeQuery = true)
    public Employee testQuery(String name,Long id);

}