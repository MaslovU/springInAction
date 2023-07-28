package com.maslov.springinaction.services;

import com.maslov.springinaction.models.TacoOrder;

public interface OrderService {
    void saveOrder(TacoOrder order);
}
