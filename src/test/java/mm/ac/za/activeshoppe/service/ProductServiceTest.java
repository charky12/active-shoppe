package mm.ac.za.activeshoppe.service;

import mm.ac.za.activeshoppe.model.Product;
import mm.ac.za.activeshoppe.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService = new ProductService(productRepository);
    private Product product;

    @Before
    public void init() {
        product = new Product("","",12);
    }

    @Test
    public void getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(product);
        when(productRepository.findAll()).thenReturn(products);
        List<Product> productList = productService.getAllProducts();
        assertFalse(productList.isEmpty());
    }

    @Test
    public void buyProduct() {
    }

    @Test
    public void findByCode() {
        Optional<Product> optionalProduct = Optional.of(product);
        when(productRepository.getCustomerByCode("test")).thenReturn(optionalProduct);
        Optional<Product> product = productService.findByCode("test");
        assertTrue(product.isPresent());
    }
}