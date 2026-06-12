package com.example.order_service.producer;

import com.example.order_service.event.OrderCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
public class OrderProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishOrderCreated(OrderCreatedEvent event) {

        System.out.println("=== ENTERED PRODUCER METHOD ===");

        try {

            kafkaTemplate.send("order-topic", event)
                    .whenComplete((result, ex) -> {
                        if (ex != null) {
                            System.out.println("❌ Kafka failed:");
                            ex.printStackTrace();
                        } else {
                            System.out.println("✅ Kafka sent successfully");
                        }
                    });

            System.out.println("AFTER SEND");

        } catch (Exception e) {

            System.out.println("EXCEPTION INSIDE PRODUCER");
            e.printStackTrace();
        }
    }
}