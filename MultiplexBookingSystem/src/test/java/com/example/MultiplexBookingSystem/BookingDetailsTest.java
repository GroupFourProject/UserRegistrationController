package com.example.MultiplexBookingSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

import com.dao.BookingDetailsService;
import com.model.BookingDetails;

@SpringBootTest
class BookingDetailsTest {
	@Autowired
	BookingDetailsService service;

	@Test
	void testAdd() {
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setNoOfSeats(250);
		service.add(bookingDetails);
		
		BookingDetails bookingDetails_to_be_tested = service.find(bookingDetails.getBookingId());
		Assert.assertEquals(250, bookingDetails_to_be_tested.getNoOfSeats());	
	}

	@Test
	void testFind() {
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setNoOfSeats(250);
		
		try {
			service.add(bookingDetails);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		BookingDetails bookingDetails1 = service.find(bookingDetails.getNoOfSeats());
		Assert.assertNull(bookingDetails1);
	}

	@Test
	void testFindAll() {
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setNoOfSeats(252);
		service.add(bookingDetails);
		BookingDetails bookingDetails1 = new BookingDetails();
		bookingDetails1.setNoOfSeats(200);
		service.add(bookingDetails1);
		BookingDetails boookingDetails2 = new BookingDetails();
		boookingDetails2.setNoOfSeats(150);
		
		service.add(boookingDetails2);
		List<BookingDetails> details = service.findAll();
		Assert.assertEquals(details.get(0).getNoOfSeats(), 250);
		Assert.assertEquals(details.get(2).getNoOfSeats(), 200);
		Assert.assertEquals(details.get(3).getNoOfSeats(), 150);
	}

	@Test
	void testUpdate() {
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setNoOfSeats(100);
		service.add(bookingDetails);
		service.update(bookingDetails);
		Assert.assertEquals(true, service.update(bookingDetails));
	}

	@Test
	void testDelete() {
		BookingDetails bookingDetails = new BookingDetails();
		BookingDetails bookingDetails1 = service.find(1);
		service.delete(1);
	}

}
