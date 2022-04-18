package com.example.UserProject;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.UserrService;
import com.model.Userr;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;
import junit.framework.Assert;

@SpringBootTest
class UserrTest {
	
	@Autowired
	UserrService service;

	@Test
	void testAdd() {
		Userr user = new Userr();
		user.setUserrName("Omkar");
		user.setUserrType('M');
		user.setMobileNo("7888182880");
		user.setEmailId("omkar27salunke@gmail.com");
		service.add(user);
		
	Userr user_tested =service.find(user.getUserrId());
	Assert.assertEquals("Omkar", user_tested.getUserrName());
	Assert.assertEquals('M',user_tested.getUserrType());
	Assert.assertEquals("7888182880",user_tested.getMobileNo());
	Assert.assertEquals("omkar27salunke@gmail.com",user_tested.getEmailId());

		
	}

	@Test
	void testFind() {
	
		Userr user = new Userr();
		//user.setUserrId(2);
		
		Userr user2=service.find(user.getUserrId());
//		user.setUserrName("Omkar");
//		try {
//			service.add(user);
//			
//		}
//		catch(Exception e) {
//			System.out.println(e);
//			
//		}
//		Userr user2=service.find(user.getUserrId());
//		Assert.assertNull(user2);
			
		
	}

	@Test
	void testFindAll() {
	
		Userr user=new Userr();
		user.setUserrName("Amit");
		user.setUserrType('M');
		user.setMobileNo("7888189365");
		user.setEmailId("amit@gmail.com");
		service.add(user);
		
		Userr user1=new Userr();
		user1.setUserrName("Sumit");
		user1.setUserrType('M');
		user1.setMobileNo("7888106257");
		user1.setEmailId("sumit@gmail.com");
		service.add(user1);
		
		Userr user2=new Userr();
		user2.setUserrName("Pooja");
		user2.setUserrType('M');
		user2.setMobileNo("9767242095");
		user2.setEmailId("pooja97@gmail.com");
		service.add(user2);
		List<Userr> userlist = service.findAll();
		
		Assert.assertEquals(userlist.get(0).getUserrName(), "Omkar");
		Assert.assertEquals(userlist.get(1).getUserrName(), "Amit");
		Assert.assertEquals(userlist.get(2).getUserrName(), "Sumit");
		Assert.assertEquals(userlist.get(3).getUserrName(), "Pooja");
		
	}

	@Test
	void testUpadte() {
		Userr user = new Userr();
		user.setUserrName("Ketki");
		user.setUserrType('F');
		user.setMobileNo("7888182888");
		user.setEmailId("ketki78@gmail.com");
		service.add(user);
		user.setUserrId(2);
		service.upadte(user);
		
		Assert.assertEquals(true,service.upadte(user));

	}

	@Test
	void testDelete() {
		Userr user = new Userr();
		
		Userr user1=service.find(1);
		service.delete(1);
		
		//Assert.assertEquals(false,service.delete(user));
	}

}
