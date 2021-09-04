package webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webservice.model.Customer;
import webservice.service.IcustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    IcustomerService icustomerService;

    @GetMapping
    public Iterable<Customer> customerFindAll() {
        return icustomerService.findAll();
    }
//     Cách 2
//    @GetMapping
//    public ResponseEntity<Iterable<Customer>> findAllCustomer() {
//        List<Customer> customers = (List<Customer>) icustomerService.findAll();
//        if (customers.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        Customer customer = icustomerService.findById(id);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    // Cách 2

//    @GetMapping("/{id}")
//    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
//        Optional<Customer> customerOptional = Optional.ofNullable(icustomerService.findById(id));
//        if (!customerOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
//    }



    @GetMapping("/name")
    public Iterable<Customer> customerFindByName(@Param("name") String name) {
        return icustomerService.findByName(name);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Customer customer) {
        icustomerService.save(customer);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity edit(@RequestBody Customer customer) {
        icustomerService.save(customer);
        return new ResponseEntity(HttpStatus.OK);
    }
//     cách 2
//    @PutMapping("/{id}")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
//        Optional<Customer> customerOptional = Optional.ofNullable(icustomerService.findById(id));
//        if (!customerOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        customer.setId(customerOptional.get().getId());
//        icustomerService.save(customer);
//        return new ResponseEntity<>( HttpStatus.OK);
//    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        icustomerService.remove(icustomerService.findById(id));
        return new ResponseEntity(HttpStatus.OK);
    }

    // Cách 2

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
//        Optional<Customer> customerOptional = Optional.ofNullable(icustomerService.findById(id));
//        if (!customerOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        icustomerService.remove(icustomerService.findById(id));
//        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
//    }

}