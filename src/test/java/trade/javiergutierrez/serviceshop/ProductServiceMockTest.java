package trade.javiergutierrez.serviceshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import trade.javiergutierrez.serviceshop.entity.Category;
import trade.javiergutierrez.serviceshop.entity.Product;
import trade.javiergutierrez.serviceshop.repository.ProductRepository;
import trade.javiergutierrez.serviceshop.service.ProductService;
import trade.javiergutierrez.serviceshop.service.ProductServiceImpl;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {
    @Mock
    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
        Product villacampas = Product.builder()
                .id(1L)
                .name("Kelme Villacampa")
                .category(Category.builder().id(1L).build())
                .description("Las zapatillas de Villacampa")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("124.99"))
                .build();

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(villacampas));
    }

    @Test
    public void whenValidGetID_ThenReturnProduct(){
        Product found = productService.getProduct(1L);
        assert(found.getName()).equals("Kelme Villacampa");
    }

}
