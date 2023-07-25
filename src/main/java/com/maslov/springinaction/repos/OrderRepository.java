package com.maslov.springinaction.repos;

import com.maslov.springinaction.models.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder order);
}
