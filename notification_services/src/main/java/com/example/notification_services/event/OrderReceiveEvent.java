package com.example.notification_services.event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderReceiveEvent {
    private Long orderid;
    private Long userid;
    private Long productid;
    private Integer quantity;
    private Double price;
}
