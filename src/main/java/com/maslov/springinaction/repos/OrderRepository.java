package com.maslov.springinaction.repos;

import com.maslov.springinaction.models.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}
