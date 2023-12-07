package com.Foodie.App.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodie.App.webservice.entity.Payment;
import com.Foodie.App.webservice.repository.PaymentRepository;


@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	//Get All Payments
	public List<Payment> getPayments(){
		return paymentRepository.findAll();
	}
	
	//Get one Payment by paymentId
	public Payment getPayment(int paymentId) {
		return paymentRepository.findById(paymentId).get();
	}
	
	//Add Payment
	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	//Update Payment
	public Payment updatePayment(Payment payment) {
		if(paymentRepository.existsById(payment.getPaymentId()))
			return paymentRepository.save(payment);
		else
			return null;
				
	}
	
	//Delete Payment
	public void deletePayment(int paymentId) {
		paymentRepository.deleteById(paymentId);
				
	}
}
