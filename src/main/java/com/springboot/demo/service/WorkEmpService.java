package com.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.demo.model.Emp;
import com.springboot.demo.model.EmpRepository;
import com.springboot.demo.model.WorkMessages;
import com.springboot.demo.model.WorkMessagesRepository;

@Service
public class WorkEmpService {
	
	@Autowired
	private EmpRepository dao;
	
	public void insert(Emp emp) {
		dao.save(emp);
	}
	
	public Emp findById(Integer id) {
		Optional<Emp> op = dao.findById(id);
	    
		if(op.isPresent()) {
			return op.get();
		}
		  
		  return null;
	}
	
	public void delete(Integer id) {
		dao.deleteById(id);
	}
	
	public List<Emp> findAllEmp(){
		List<Emp> Emps = dao.findAll();
		
		return Emps;
	}
	
	public Page<Emp> findByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber -1, 3, Sort.Direction.DESC,"added");
		
		return dao.findAll(pgb);
	}
	


}
