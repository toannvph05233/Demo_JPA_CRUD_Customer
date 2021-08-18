package repository;

import model.Customer;

import java.util.ArrayList;

public interface ICustomerRepo {
    Customer save(Customer customer);

    ArrayList<Customer> findAll();

    void Delete(Customer customer);

    void edit(Customer customer);
}
