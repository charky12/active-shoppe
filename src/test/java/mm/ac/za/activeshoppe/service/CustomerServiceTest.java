package mm.ac.za.activeshoppe.service;

import mm.ac.za.activeshoppe.model.Customer;
import mm.ac.za.activeshoppe.model.Product;
import mm.ac.za.activeshoppe.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerService customerService = new CustomerService(customerRepository);

    private Customer customer;

    @Before
    public void init() {
        customer = new Customer("Marry",12);
    }

    @Test
    public void getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        when(customerRepository.findAll()).thenReturn(customers);
        List<Customer> customerList = customerService.getAllCustomers();
        assertFalse(customerList.isEmpty());
    }

    @Test
    public void getCustomerById() {
        Optional<Customer> optionalCustomer = Optional.of(customer);
        when(customerRepository.findById(1)).thenReturn(optionalCustomer);
        Customer customer = customerService.getCustomerById(1);
        assertNotNull(customer);
    }
}