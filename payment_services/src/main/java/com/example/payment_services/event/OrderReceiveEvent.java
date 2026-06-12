package com.example.payment_services.event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderReceiveEvent {
    private Long orderid;
    private Long userid;
    private Long productid;
    private Integer quantity;
    private Double price;
}

