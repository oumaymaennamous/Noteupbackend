package ensa.gestionnotes.projet_jee.repository;

import ensa.gestionnotes.projet_jee.Entity.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SemestreRepository extends JpaRepository<Semestre,Long> {
    @Query("SELECT s FROM Semestre s WHERE s.semestre = :name AND s.promo.idPromo = :idPromo")
    Semestre findSemestreByPromoAndName(@Param("name") String name, @Param("idPromo") long idPromo);
    @Query("SELECT s FROM Semestre s WHERE s.promo.idPromo= :promo AND s.annee= :annee")
    Semestre findSemestreBypromoAndAnnee(Long promo,String annee);
    @Query("SELECT s FROM Semestre s WHERE s.promo.idPromo= :promoId")
    List<Semestre> findByPromoId(@Param("promoId")long promoId);

}
