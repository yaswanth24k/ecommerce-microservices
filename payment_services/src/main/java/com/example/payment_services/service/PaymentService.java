package com.example.payment_services.service;

import com.example.payment_services.entity.Payment;
import com.example.payment_services.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    public Payment savepayment(Payment payment)
    {
        return paymentRepository.save(payment);
    }
}
