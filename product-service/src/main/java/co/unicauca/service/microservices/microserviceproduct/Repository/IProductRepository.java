package co.unicauca.service.microservices.microserviceproduct.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import co.unicauca.service.microservices.microserviceproduct.Entity.Category;
import co.unicauca.service.microservices.microserviceproduct.Entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByCategory(Category category);
}