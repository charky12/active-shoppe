package mm.ac.za.activeshoppe.repository;

import mm.ac.za.activeshoppe.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Optional<Product> getCustomerByCode(String code);
}