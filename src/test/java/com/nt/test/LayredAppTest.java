package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.controller.StudentController;
import com.nt.vo.StudentVo;

public class LayredAppTest {

	public static void main(String[] args) {
		StudentController controller = null;
		String sno = null;
		String sname = null;
		String m1, m2, m3 = null;
		Resource res = null;
		BeanFactory factory = null;

		// locate Spring Bean Configuration file;
		res = new ClassPathResource("com/nt/cfgs/applicationContext.xml");
		// load ioc contailer
		factory = new XmlBeanFactory(res);
		// get Bean id
		controller = factory.getBean("studentController", StudentController.class);

		StudentVo vo = new StudentVo();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Serial Number");
		sno = sc.next();
		System.out.println("Enter Student Name");

		sname = sc.next();
		System.out.println("Enter Student Marks M1");
		m1 = sc.next();
		System.out.println("Enter Student Marks M2");
		m2 = sc.next();
		System.out.println("Enter Student Marks M3");

		m3 = sc.next();
		// put in vo object
		vo.setSno(sno);
		vo.setSname(sname);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
		try {
			System.out.println(controller.process(vo));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
