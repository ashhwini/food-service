package com.stackroute.foodservice.configuration;

import com.stackroute.foodservice.domain.Customer;
import com.stackroute.foodservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class AppListener implements ApplicationListener {
    private CustomerRepository customerRepository;

    @Autowired
    Environment environment;

    @Value("${restaurantId1}")
    int restaurantId;

    @Autowired
    public AppListener(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Order(1)
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        customerRepository.save(new Customer(restaurantId,environment.getProperty("restaurantName1"),environment.getProperty("address1"),environment.getProperty("city1")));
    }
}
