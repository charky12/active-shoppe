package mm.ac.za.activeshoppe.service;

import mm.ac.za.activeshoppe.model.Customer;
import mm.ac.za.activeshoppe.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //getting all customers records
    public List<Customer> getAllCustomers() {
        List<Customer> products = new ArrayList<Customer>();
        customerRepository.findAll().forEach(products::add);
        return products;
    }

    //getting a specific record
    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).get();
    }

}