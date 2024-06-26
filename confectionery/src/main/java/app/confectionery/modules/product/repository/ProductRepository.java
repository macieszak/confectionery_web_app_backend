package app.confectionery.modules.product.repository;

import app.confectionery.modules.product.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryAndPriceBetween(String category, Double minPrice, Double maxPrice);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findAll(Sort sort);

}
