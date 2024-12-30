package ensa.gestionnotes.projet_jee.repository;

import ensa.gestionnotes.projet_jee.Entity.Promo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PromoRepository extends JpaRepository<Promo, Long> {
    @Override
    List<Promo> findAll();
    Promo findByNamePromo(String name);


}
