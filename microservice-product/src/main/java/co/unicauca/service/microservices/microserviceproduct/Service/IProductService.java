package co.unicauca.service.microservices.microserviceproduct.Service;

import co.unicauca.service.microservices.microserviceproduct.Entity.Category;
import co.unicauca.service.microservices.microserviceproduct.Entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product> listAllProduct();
    public Product getProduct(Long id);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public  Product deleteProduct(Long id);
    public List<Product> findByCategory(Category category);
    public Product updateStock(Long id, Double quantity);
}
