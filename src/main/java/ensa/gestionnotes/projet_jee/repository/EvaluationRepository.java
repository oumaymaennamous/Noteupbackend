package ensa.gestionnotes.projet_jee.repository;

import ensa.gestionnotes.projet_jee.Entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    @Query("SELECT e FROM Evaluation e " +
            "JOIN e.mode_evaluation me " +
            "WHERE me.codeMode= :modeId")
    List<Evaluation> findEvaluationsByMode(@Param("modeId") Long modeId);
    @Query("SELECT e FROM Evaluation e WHERE e.elementModule.codeElementModule= :idElement AND e.mode_evaluation.codeMode= :idMode")
    List<Evaluation> findEvaluationsBycodeElementAndMode(@Param("idElement") long idElement,@Param("idMode")long idMode);

}
