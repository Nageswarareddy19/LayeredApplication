package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String STUDENT_INSERT = "INSERT INTO SP_STUDENT VALUES(?,?,?,?,?)";

	private DataSource ds;

	public StudentDAOImpl(DataSource ds) {
		this.ds = ds;
	}

	public int insert(StudentBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		// get Connection Object
		con = ds.getConnection();
		// create Prepared Statement object
		ps = con.prepareStatement(STUDENT_INSERT);
		// send sql param values Db software
		ps.setInt(1, bo.getSno());
		ps.setString(2, bo.getSname());
		ps.setInt(3, bo.getTotal());
		ps.setFloat(4, bo.getAvg());
		ps.setString(5, bo.getResult());
		// execute the query
		result = ps.executeUpdate();

		return result;
	}
	public int delete(StudentBO bo) throws Exception{
	//delete method is added

	}

	}

}
