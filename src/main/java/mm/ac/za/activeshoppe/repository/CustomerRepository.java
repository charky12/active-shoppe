package mm.ac.za.activeshoppe.repository;

import mm.ac.za.activeshoppe.model.Customer;
import mm.ac.za.activeshoppe.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer>
{  
} 