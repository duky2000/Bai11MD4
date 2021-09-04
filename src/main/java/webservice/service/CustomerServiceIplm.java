package webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webservice.model.Customer;
import webservice.repository.IcustomerRepository;

@Service
public class CustomerServiceIplm implements IcustomerService{
    @Autowired
    IcustomerRepository icustomerRepository;
    @Override
    public Iterable<Customer> findAll() {
        return icustomerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return icustomerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        icustomerRepository.save(customer);
    }

    @Override
    public void remove(Customer customer) {
icustomerRepository.delete(customer);
    }

    @Override
    public Iterable<Customer> findByName(String name) {
        return icustomerRepository.findByNameContaining(name);
    }
}
