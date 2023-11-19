package trade.javiergutierrez.serviceshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import trade.javiergutierrez.serviceshop.entity.Category;
import trade.javiergutierrez.serviceshop.entity.Product;
import trade.javiergutierrez.serviceshop.repository.ProductRepository;

import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryMockTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory_thenReturnListProduct(){
        Product product01 = Product.builder()
                .name("Sudadera Nike")
                .category(Category.builder().id(2L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("10"))
                .status("Created")
                .createAt(new Date())
                .build();
        productRepository.save(product01);

        List<Product> founds = productRepository.findByCategory(product01.getCategory());

        Assertions.assertEquals(3, founds.size());

    }
}

