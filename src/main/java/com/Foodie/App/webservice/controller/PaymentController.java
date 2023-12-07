package com.Foodie.App.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Foodie.App.webservice.dto.ResponseDto;
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
	public Payment getPayment(@PathVariable int paymentId){
		return paymentService.getPayment(paymentId);
	}
	
	@PostMapping("/payments")
	public Payment addPayment(@RequestBody Payment payment){
		return paymentService.addPayment(payment);
	}
	
	@PutMapping("/payments")
	public Payment updatePayment(@RequestBody Payment payment) {
		return paymentService.updatePayment(payment);
	}
	
	@DeleteMapping("/payments/{paymentId}")
	public ResponseDto deletePayment(@PathVariable int paymentId){
		paymentService.deletePayment(paymentId);
		return new ResponseDto("Payment is deleted sucessfully with paymentId : "+paymentId);
	}

}
