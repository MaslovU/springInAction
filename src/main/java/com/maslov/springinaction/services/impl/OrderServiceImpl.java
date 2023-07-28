package com.maslov.springinaction.services.impl;

import com.maslov.springinaction.models.TacoOrder;
import com.maslov.springinaction.services.DataProvider;
import com.maslov.springinaction.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final DataProvider provider;

    public OrderServiceImpl(DataProvider provider) {
        this.provider = provider;
    }

    @Override
    public void saveOrder(TacoOrder tacoOrder) {
        log.info("Order submitted: {}", tacoOrder);
        provider.saveTacoOrder(tacoOrder);
    }
}
