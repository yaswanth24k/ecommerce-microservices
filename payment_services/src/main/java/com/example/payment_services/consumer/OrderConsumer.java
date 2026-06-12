package com.example.payment_services.consumer;

import com.example.payment_services.entity.Payment;
import com.example.payment_services.event.OrderReceiveEvent;
import com.example.payment_services.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    @Autowired
    private  PaymentRepository paymentRepository;


    @KafkaListener(
            topics = "order-topic",
            groupId = "payment-group"
    )
    public void consume(OrderReceiveEvent event) {

        Payment payment = new Payment();

        payment.setUserid(event.getUserid());
        payment.setAmount(event.getPrice());
        payment.setOrderid(event.getOrderid());
        payment.setStatus("SUCCESS");

        paymentRepository.save(payment);

        System.out.println("Payment saved for Order ID: " + event.getOrderid());
    }
}
