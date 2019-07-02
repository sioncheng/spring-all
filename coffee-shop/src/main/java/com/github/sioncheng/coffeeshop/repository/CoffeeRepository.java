package com.github.sioncheng.coffeeshop.repository;

import com.github.sioncheng.coffeeshop.entities.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
