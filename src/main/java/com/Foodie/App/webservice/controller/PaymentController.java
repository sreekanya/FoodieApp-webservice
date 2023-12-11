package com.Foodie.App.webservice.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Foodie.App.webservice.dto.ResponseDto;
import com.Foodie.App.webservice.entity.Orders;
import com.Foodie.App.webservice.entity.Payment;
import com.Foodie.App.webservice.service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/payments")
	public List<Payment> getAllPayments(){
		return paymentService.getPayments();
	}
	
	@GetMapping("/payments/{paymentId}")
	public ResponseDto getPayment(@PathVariable int paymentId){
		
		Optional<Payment> payment = paymentService.getPayment(paymentId);
		return new ResponseDto("Payment is found sucessfully with paymentId : "+paymentId, new Date(),HttpStatus.OK.name(),payment);

	}
	
	@PostMapping("/payments")
	public ResponseDto addPayment(@RequestBody Payment payment){
		
		Payment newPayment = paymentService.addPayment(payment);
		 return new ResponseDto("Payment is created sucessfully ", new Date(),HttpStatus.OK.name(),newPayment);
	}
	
	@PutMapping("/payments")
	public ResponseDto updatePayment(@RequestBody Payment payment) { 
		
		Payment paymentUpdated = paymentService.updatePayment(payment);
		return new ResponseDto("Payment is updated sucessfully.", new Date(),HttpStatus.OK.name(),paymentUpdated);
	}
	
	@DeleteMapping("/payments/{paymentId}")
	public ResponseDto deletePayment(@PathVariable int paymentId){
		paymentService.deletePayment(paymentId);
		return new ResponseDto("Payment is deleted sucessfully with paymentId : "+paymentId,new Date(),HttpStatus.OK.name(),null);
	}

}
