package com.Foodie.App.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodie.App.webservice.entity.Orders;
import com.Foodie.App.webservice.entity.Payment;
import com.Foodie.App.webservice.exception.BadRequestException;
import com.Foodie.App.webservice.exception.NotFoundException;
import com.Foodie.App.webservice.repository.PaymentRepository;
import com.Foodie.App.webservice.util.StringUtil;


@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	//Get All Payments
	public List<Payment> getPayments(){
		return paymentRepository.findAll();
	}
	
	//Get one Payment by paymentId
	public Optional<Payment> getPayment(int paymentId) {
		
		Optional<Payment> payment = paymentRepository.findById(paymentId);
		if(payment.isPresent() && StringUtil.isNotNull(payment))
			return payment;
		else 
			throw new NotFoundException("Payment with provided paymentId not found");
	
	}
	
	//Add Payment
	public Payment addPayment(Payment payment) {
		
		if(paymentRepository.existsByOrderId(payment.getOrderId()) )
			throw new BadRequestException("Payment with orderId already exists.");

		return paymentRepository.save(payment);
	}
	
	//Update Payment
	public Payment updatePayment(Payment payment) {
				
		if(payment.getPaymentId() <=0 )
			throw new BadRequestException("PaymentId cannot be null or empty.");

		if(paymentRepository.existsById(payment.getPaymentId()))
			return paymentRepository.save(payment);
		else 
			throw new NotFoundException("Payment does not exist with provided paymentId.");
	}
	
	//Delete Payment
	public void deletePayment(int paymentId) {
		
		if(paymentId <=0 )
			throw new BadRequestException("PaymentId cannot be null or empty.");
		if(paymentRepository.existsById(paymentId))
			paymentRepository.deleteById(paymentId);
		else 
			throw new NotFoundException("Payment does not exist with provided paymentId.");
				
				
	}
}
