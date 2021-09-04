package webservice.service;

import webservice.model.Customer;

public interface IcustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Customer customer);

    Iterable<Customer> findByName(String name);

}
