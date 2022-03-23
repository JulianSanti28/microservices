package co.unicauca.service.microservices.microserviceproduct;

import co.unicauca.service.microservices.microserviceproduct.Entity.Category;
import co.unicauca.service.microservices.microserviceproduct.Entity.Product;
import co.unicauca.service.microservices.microserviceproduct.Repository.IProductRepository;
import co.unicauca.service.microservices.microserviceproduct.Service.IProductService;
import co.unicauca.service.microservices.microserviceproduct.Service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {
    //Se trabajan con datos Mockeados, se trae la instancia del repo
    @Mock
    private IProductRepository productRepository;
    /**
     * Servicio: No se usa inyección de dependencias, luego se creará una instancia de la implementación
     *  para testear
     */
    private IProductService productService;
    /**
     * Esto se debe ejecutar antes de realizar el test, lo que se hace
     * es mockear un producto, para luego testear
     */
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository); //Estamos haciendo inyección de dependencias pero por constructor
        Product computer =  Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble("12.5"))
                .stock(Double.parseDouble("5"))
                .build();
        //Cuando se busque un producto con ID = 1, vamos a retornar el objeto que acabo de crear
        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));
        //Cuando se guarde un producto computer(el que se mockeo) se debe retornar ese producto
        Mockito.when(productRepository.save(computer)).thenReturn(computer);
        //Cuando se guarde el producto mockeado(update) retornar el mismo producto actualizado
        Mockito.when(productRepository.save(computer)).thenReturn(computer);
    }

    /**
     * Inicia una búsqueda del producto Mockeado y cuando se use el método getProduct con el ID  = 1
     * lo que debe devovler es justamente el producto mockeado
     */
    @Test
    public void whenValidGetID_ThenReturnProduct(){
        Product found = productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");
    }
    @Test
    public void whenValidUpdateStock_ThenReturnNewStock(){
        //Si al producto mockeado es decir con ID = 1 se le agregan 8 de Stock, la salida deberá ser 13
        //debido a que se inicio con 5.
        Product newStock = productService.updateStock(1L,Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
    }


}
