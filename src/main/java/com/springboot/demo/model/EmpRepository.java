package com.springboot.demo.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpRepository extends JpaRepository<Emp, Integer>{

	@Query("from Customer where name = :name")
	public List<Emp> findByName(@Param(value = "name") String name);
	
	@Query(value="select * from Customer where name = :name",nativeQuery=true)
	public List<Emp> findByName2(@Param(value = "name") String name);
	
//	@Transactional
//	@Modifying
//	@Query(value = "update Emp e set e.Email = :Email ,e. where e.name = :name")
//	public void updateEmail(@Param("name") String name, @Param("Email") String Email);
	


//	public List<Emp> findByDepartment(String department);

}
