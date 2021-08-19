package repository;

import model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IRepositoryCustomer extends PagingAndSortingRepository<Customer, Integer> {

    @Query(value = "select c from Customer c where c.name like concat('%',:name,'%')")
    ArrayList<Customer> findAllByName(@Param("name") String name);
}
