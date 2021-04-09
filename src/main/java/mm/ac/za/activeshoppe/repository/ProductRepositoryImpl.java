package mm.ac.za.activeshoppe.repository;

import mm.ac.za.activeshoppe.model.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Component // Must be @Component !!
public class ProductRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unused")
    public Product findProductByCode(String code) {
        String hql = "SELECT eFROM Product e WHERE e.code = :code";
        TypedQuery<Product> query = entityManager.createQuery(hql, Product.class);
        query.setParameter("code", code);
        return query.getSingleResult();
    }
}
