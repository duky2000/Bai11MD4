package webservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webservice.model.Customer;
@Repository
public interface IcustomerRepository extends CrudRepository<Customer,Long> {
    Iterable<Customer> findByNameContaining(String name);
}
