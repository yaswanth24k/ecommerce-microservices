package com.example.notification_services.consumer;

import com.example.notification_services.event.OrderReceiveEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(
            topics = "order-topic",
            groupId = "notification-group"
    )
    public void consume(OrderReceiveEvent event) {
        System.out.println("\n========== NOTIFICATION SERVICE ==========");
        System.out.println("Order Placed Successfully!");
        System.out.println("Order ID: " + event.getOrderid());
        System.out.println("User ID: " + event.getUserid());
        System.out.println("Total Amount: " + event.getPrice());
        System.out.println("=========================================\n");
    }
}
