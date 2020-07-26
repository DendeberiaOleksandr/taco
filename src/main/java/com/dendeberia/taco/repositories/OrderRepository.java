package com.dendeberia.taco.repositories;

import com.dendeberia.taco.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
