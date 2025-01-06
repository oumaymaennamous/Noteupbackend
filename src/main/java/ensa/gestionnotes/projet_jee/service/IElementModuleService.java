package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Element_Module;
import ensa.gestionnotes.projet_jee.Entity.Etudiant;
import ensa.gestionnotes.projet_jee.Entity.Mode_Evaluation;
import ensa.gestionnotes.projet_jee.dto.ElementDTO;
import ensa.gestionnotes.projet_jee.dto.ElementModuleDTO;
import ensa.gestionnotes.projet_jee.dto.EtudiantDtoReponse;
import ensa.gestionnotes.projet_jee.dto.ModeEvaluationDTO;

import java.util.List;

public interface IElementModuleService {
    public List<ElementModuleDTO> getElementsByModuleId(Long moduleId);
    public ElementModuleDTO createElement(Long moduleId, ElementModuleDTO elementDTO);
    public void deleteElement(Long elementId);
    public ModeEvaluationDTO addEvaluationMode(Long elementId, ModeEvaluationDTO evaluationDTO);
    public ModeEvaluationDTO updateEvaluationMode(Long evaluationId, ModeEvaluationDTO evaluationDTO);
    public void deleteEvaluationMode(Long evaluationId);
   public  ElementModuleDTO convertToDTO(Element_Module element);
   public  ModeEvaluationDTO convertToDTO(Mode_Evaluation mode);

   public List<ElementDTO> getElementModulesByProfessor(String cin);

   public List<EtudiantDtoReponse> getEtudiantsByElement(Long elementId);

}
