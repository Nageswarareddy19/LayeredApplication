package com.nt.controller;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVo;

public class StudentControllerImpl implements StudentController {
	private StudentService service;

	public StudentControllerImpl(StudentService service) {
		this.service = service;
	}

	public String process(StudentVo vo) throws Exception {
		//convert studentVo to Student DTO object
		StudentDTO dto=null;
		String result=null;
		dto=new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		//use service
		result=service.generateResult(dto);


		return result;
	}

}
