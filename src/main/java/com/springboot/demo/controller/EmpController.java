package com.springboot.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.demo.model.Emp;
import com.springboot.demo.service.WorkEmpService;

@Controller
public class EmpController {

	@Autowired
	private WorkEmpService service;

	@PostMapping(value = "/addEmp")
	public ModelAndView postNewMessage(ModelAndView mav, @Valid @ModelAttribute(name = "Emp") Emp emp,
			BindingResult rs) {

		if (!rs.hasErrors()) {
			service.insert(emp);
			Emp newEmp = new Emp();
			mav.getModel().put("Emp", newEmp);
		}

//		Emp lastestEmp = service.getLastest();
//		mav.getModel().put("lastestEmp", lastestEmp);
//
//		mav.setViewName("messages/addEmp");

		return mav;
	}



//	@GetMapping("/editMessage")
//	public ModelAndView editMessagePage(ModelAndView mav, @RequestParam(name = "id") Integer id) {
//		mav.setViewName("messages/editMessage");
//		Emp msg = service.findById(id);
//
//		mav.getModel().put("workMessage", msg);
//
//		return mav;
//	}

//	@PostMapping("/editMessage")
//	public ModelAndView editMessagePage(ModelAndView mav, @Valid @ModelAttribute(name = "workMessage") WorkMessages msg,
//			BindingResult result) {
//		mav.setViewName("messages/editMessage");
//		if (!result.hasErrors()) {
//			// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.entity-persistence.saving-entites
//			service.insert(msg);
//			mav.setViewName("redirect:/viewMessages");
//		}
//		return mav;
//	}

	@GetMapping("/deleteEmp")
	public ModelAndView deleteMessagePage(ModelAndView mav, @RequestParam(name = "id") Integer id) {
		service.delete(id);
		mav.setViewName("redirect:/ajaxMessages");
		return mav;
	}

//	@ResponseBody
//	@PostMapping("/api/postMessage")
//	public List<WorkMessages> postMessageApi(@RequestBody MessageDto dto) {
//		String text = dto.getMsg();
//		Emp workEmp = new Emp();
//		workEmp.setText(text);
//		service.insert(workMsg);
//		Page<Emp> page = service.findByPage(1);
//		List<Emp> list = page.getContent();
//		return list;
//	}

}
