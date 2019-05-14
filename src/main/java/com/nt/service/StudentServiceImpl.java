package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {

	private StudentDAO dao;

	public StudentServiceImpl(StudentDAO dao) {
		this.dao = dao;
	}

	public String generateResult(StudentDTO dto) throws Exception {
		StudentBO bo = null;
		int total = 0;
		float avg = 0.0f;
		String result = null;

		int count = 0;
		// write the business logic
		total = dto.getM1() + dto.getM2() + dto.getM3();
		avg = total / 3.0f;
		if (dto.getM1() < 35 || dto.getM2() < 35 || dto.getM3() < 35)
			result = "fail";
		else
			result = "pass;";

		// Convert StudentDTO to Studett BO
		bo = new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setTotal(total);
		bo.setResult(result);
		// use dao
		count = dao.insert(bo);
		if (count == 0)
			return "student Registration is failed " + result;
		else
			return "student Registration is successed " + result;

	}

}
