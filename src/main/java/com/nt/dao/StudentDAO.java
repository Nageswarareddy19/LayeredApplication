package com.nt.dao;

import com.nt.bo.StudentBO;

public interface StudentDAO {
	public int insert(StudentBO bo)throws Exception;
	public int update(StudentBo bo)throws Exception;
	public int delete(StudentBo bo)throws Exception;

}
