package com.hau.service;

import com.hau.dto.ErrorDTO;
import com.hau.dto.PaymentDto;
import com.hau.model.Customer;
import com.hau.model.OrderService;

import java.util.List;

public interface IOrderService {
    ErrorDTO saveOrder(OrderService productOrder);

    List<OrderService> getProductInCardByCustomer(Customer customer);

    Boolean minusQuantity(OrderService orderService);

    Boolean plusQuantity(OrderService orderService);

    Boolean findProductOrder(OrderService orderService);

    PaymentDto goPayment(Customer customer);
}
