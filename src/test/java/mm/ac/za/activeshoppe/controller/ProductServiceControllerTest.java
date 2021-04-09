package mm.ac.za.activeshoppe.controller;

import mm.ac.za.activeshoppe.model.Customer;
import mm.ac.za.activeshoppe.model.Product;
import mm.ac.za.activeshoppe.repository.CustomerRepository;
import mm.ac.za.activeshoppe.service.ProductService;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceControllerTest {
    @Mock
    private Logger logger;
    @Mock
    private
    ProductService productService;
    @Mock
    private
    CustomerRepository customerRepository;
    @InjectMocks
    private ProductServiceController productServiceController = new ProductServiceController(productService, customerRepository);

    @Test
    public void buyProducts() {
        List<String> codes = new ArrayList<>();
        String code = "0004";
        int customerId = 12;
        codes.add(code);
        Customer customer = new Customer("Marry",customerId);
        Optional<Customer> optionalCustomer = Optional.of(customer);
        Product product = new Product("",code,customerId);
        Optional<Product> optionalProduct = Optional.of(product);
        when(productService.findByCode(code)).thenReturn(optionalProduct);
        when(customerRepository.findById(12)).thenReturn(optionalCustomer);
        ResponseEntity responseEntity = productServiceController.buyProducts(customerId, codes);
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());

    }
}
