package com.github.sioncheng.coffeeshop.repository;

import com.github.sioncheng.coffeeshop.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
