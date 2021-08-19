package service;

import model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface ICustomerService {
    Customer save(Customer customer);

    Customer findById(int id);

    ArrayList<Customer> findAll();

    ArrayList<Customer> findAllByName(String name);

    Page<Customer> findAll(Pageable pageable);

    void Delete(Customer customer);

    void edit(Customer customer);
}
