package com.springboot.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.model.Customer;
import com.springboot.demo.model.CustomerRepository;
import com.springboot.demo.model.Emp;
import com.springboot.demo.model.EmpRepository;

@RestController
public class EmpApi {

	@Autowired
	private EmpRepository empDao;


	

	@PostMapping(value = "Emp/insert")
	public Emp insertEmp(@RequestBody Emp emp) {
		Emp res = empDao.save(emp);
		return res;
	}

	@PostMapping(value = "Emp/insertAll")
	public List<Emp> insertAll(@RequestBody List<Emp> Emps) {
		List<Emp> res = empDao.saveAll(Emps);
		return res;
	}

	@GetMapping(value = "Emp")
	public Emp getById(@RequestParam Integer id) {
		// http://localhost:8080/my-app/customer/?id=3
		Optional<Emp> option = empDao.findById(id);

		if (option.isPresent()) {
			return option.get();
		}

		return null;

	}

	

	
	@GetMapping(value = "Emp/page/{pageNumber}")
	public List<Emp> findByPage(@PathVariable Integer pageNumber){
		
		Pageable pgb = PageRequest.of(pageNumber-1, 2, Sort.Direction.ASC, "id");
		
		Page<Emp> page = empDao.findAll(pgb);
		
		List<Emp> resCus = page.getContent();
		
		return resCus;
		
	}
	

	
	@GetMapping(value = "Emp/name")
	public List<Emp> findByName(@RequestParam(required = true) String name){
		
		return empDao.findByName(name);
		
	}
	
//	@PostMapping(value = "Emp/update")
//	public boolean findByName2(String name, String Email){
//		
//		empDao.updateEmail(name, Email);
//		
//		return true;
//		
//	}
//	
//	@GetMapping(value = "Emp/Department")
//	public List<Emp> findByDepartment(@RequestParam String Department){
//		return  empDao.findByDepartment(Department);
//	}
	

}
