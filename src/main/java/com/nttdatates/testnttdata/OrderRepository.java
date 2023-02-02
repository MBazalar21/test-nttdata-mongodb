package com.nttdatates.testnttdata;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
    // custom methods if necessary
    public Order findByOrderNumber(String orderNumber);
}