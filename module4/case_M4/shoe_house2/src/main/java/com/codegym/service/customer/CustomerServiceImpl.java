package com.codegym.service.customer;

import com.codegym.model.Customer;

import java.util.Optional;

public class CustomerServiceImpl implements ICustomerService{

    @Override
    public Iterable<Customer> findAll() {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
