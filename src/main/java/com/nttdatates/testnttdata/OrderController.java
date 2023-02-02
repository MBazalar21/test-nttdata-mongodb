package com.nttdatates.testnttdata;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public Page<Order> getOrders(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return orderRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "date")));
    }

    @PostMapping
    public Order createOrder (
        @RequestBody Order order
    ) throws IOException {
        // calculate taxes for the order on the server-side
        if(order.getStatus() != null){
            throw new IOException("El estado no deberia ser ingresado, se autogenera");
        }
        double subtotal = order.getOrderItems().stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum();
        order.setStatus("Pending");
        double cityTax = subtotal * 0.1;
        double countyTax = (subtotal + cityTax) * 0.05;
        double stateTax = (subtotal + cityTax + countyTax) * 0.08;
        double federalTax = (subtotal + cityTax + countyTax + stateTax) * 0.02;
        order.setTaxesAmounts(cityTax + countyTax + stateTax + federalTax);
        order.setTotalTaxes(cityTax + countyTax + stateTax + federalTax);
        order.setTotalAmount(subtotal + cityTax + countyTax + stateTax + federalTax);

        return orderRepository.save(order);
    }

    @PutMapping("/{orderNumber}")
    public Order updateOrder(@PathVariable String orderNumber, @RequestBody Order order) throws IOException {
        Order existingOrder = orderRepository.findByOrderNumber(orderNumber);
        if (existingOrder == null) {
            throw new IOException("No se encontro número de orden");
        }
        if(order.getStatus().equals("Completed") || order.getStatus().equals("Rejected")){
            existingOrder.setStatus(order.getStatus());
    
            return orderRepository.save(existingOrder);
        } else {
            throw new IOException("El estado ingresado no es el correcto");
        }

    }
}