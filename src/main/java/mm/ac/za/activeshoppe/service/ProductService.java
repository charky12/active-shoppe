package mm.ac.za.activeshoppe.service;

import mm.ac.za.activeshoppe.model.Product;
import mm.ac.za.activeshoppe.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //getting all product records
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Optional<Product> findByCode(String code) {
        return productRepository.getCustomerByCode(code);
    }

}