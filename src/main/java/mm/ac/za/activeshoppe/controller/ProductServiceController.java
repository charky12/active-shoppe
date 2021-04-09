package mm.ac.za.activeshoppe.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mm.ac.za.activeshoppe.dto.ProductDTO;
import mm.ac.za.activeshoppe.exception.CustomerNotFoundException;
import mm.ac.za.activeshoppe.exception.NoEnoughPointsException;
import mm.ac.za.activeshoppe.exception.NoProductException;
import mm.ac.za.activeshoppe.exception.NoSuchProductException;
import mm.ac.za.activeshoppe.model.Customer;
import mm.ac.za.activeshoppe.model.Product;
import mm.ac.za.activeshoppe.repository.CustomerRepository;
import mm.ac.za.activeshoppe.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductServiceController {
    private Logger logger = LoggerFactory.getLogger(ProductServiceController.class);

    //autowired the ProductService class
    private ProductService productService;
    //creating a get mapping that retrieves all the products detail from the database
    private CustomerRepository customerRepository;

    public ProductServiceController(ProductService productService, CustomerRepository customerRepository) {
        this.productService = productService;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/product")
    @ApiOperation(value = "Get all products", notes = "This method returns a list of products")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Products retrieved successfully."),
            @ApiResponse(code = 500, message = "An internal server error has occurred for the supplied operation.")})
    private List<ProductDTO> getAllProducts() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        List<Product> products = productService.getAllProducts();
        if (!products.isEmpty()) {
            for (Product product : products) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setName(product.getName());
                productDTO.setCode(product.getCode());
                productDTO.setPointsCost(product.getPointsCost());
                productDTOS.add(productDTO);
            }
        }

        return productDTOS;
    }

    //creating a get mapping that retrieves the detail of a specific product
    @GetMapping("/buyProducts/{id}/{productCodes}")
    @ApiOperation(value = "Buy product(s)", notes = "This method allows you to purchase products, supply the customer id and product code(s)")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Products successfully purchased."),
            @ApiResponse(code = 500, message = "An internal server error has occurred for the supplied operation.")})
    public ResponseEntity buyProducts(@PathVariable("id") int id, @PathVariable("productCodes") List<String> productCodes) {
        logger.info("Buy Products Service Invoked: {}", productCodes.toString());
        productCodes.stream().findFirst().orElseThrow(NoProductException::new);

        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            throw new CustomerNotFoundException();
        }
        int totalPoints = 0;
        for (String code : productCodes) {
            Optional<Product> product = productService.findByCode(code);
            if (product.isPresent()) {
                totalPoints += product.get().getPointsCost();
            } else {
                throw new NoSuchProductException();
            }
        }
        logger.info("totalPoints: {}, Customer Points: {}", totalPoints, customer.get().getPointsBalance());
        if (totalPoints > customer.get().getPointsBalance()) {
            throw new NoEnoughPointsException();
        }

        customer.get().setPointsBalance(customer.get().getPointsBalance() - totalPoints);
        customerRepository.save(customer.get());
        return new ResponseEntity<>("Product successfully purchased", HttpStatus.OK);
    }
}