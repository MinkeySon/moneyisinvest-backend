package org.knulikelion.moneyisinvest.data.repository;

import org.knulikelion.moneyisinvest.data.entity.Favorite;
import org.knulikelion.moneyisinvest.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUserAndStockId(User user, String stockId);
    List<Favorite> findByUser(User user);
}
