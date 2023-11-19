package trade.javiergutierrez.serviceshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trade.javiergutierrez.serviceshop.entity.Category;
import trade.javiergutierrez.serviceshop.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
