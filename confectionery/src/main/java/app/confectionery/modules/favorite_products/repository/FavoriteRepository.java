package app.confectionery.modules.favorite_products.repository;

import app.confectionery.modules.favorite_products.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    List<Favorite> findAllByUserId(UUID userId);

    List<Favorite> findAllByProductId(Long productId);

    Optional<Favorite> findByUserIdAndProductId(UUID userId, Long productId);

}
